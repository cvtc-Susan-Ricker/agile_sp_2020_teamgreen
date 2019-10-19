#!/usr/bin/python

# Copyright 2017 Greg Neagle.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

'''createuserpkg.py
A tool for creating Apple installer packages that create/update user accounts
on macOS. Much code borrowed and/or inpsired by Per Olofsson's CreateUserPkg'''

import optparse
import sys
import getpass

from locallibs import kcpassword
from locallibs import shadowhash
from locallibs import userplist
from locallibs import userpkg


def main():
    '''Main'''
    usage = "usage: %prog [options] /path/to/output.pkg"

    parser = optparse.OptionParser(usage=usage)
    required_user_options = optparse.OptionGroup(
        parser, 'Required User Options')
    required_user_options.add_option(
        '--name', '-n', help='User shortname. REQUIRED.')
    required_user_options.add_option(
        '--uid', '-u', help='User uid. REQUIRED.')

    required_package_options = optparse.OptionGroup(
        parser, 'Required Package Options')
    required_package_options.add_option(
        '--version', '-V', help='Package version number. REQUIRED.')
    required_package_options.add_option(
        '--identifier', '-i', help='Package identifier. REQUIRED.')

    optional_user_options = optparse.OptionGroup(
        parser, 'Optional User Options')
    optional_user_options.add_option(
        '--password', '-p',
        help='User password. If this is not provided, interactively prompt for '
             'password.')
    optional_user_options.add_option(
        '--fullname', '-f', help='User full name. Optional.')
    optional_user_options.add_option('--gid', '-g', help='User gid. Optional.')
    optional_user_options.add_option(
        '--generateduid', '-G', help='GeneratedUID (UUID). Optional.')
    optional_user_options.add_option(
        '--home', '-H', help='Path to user home directory. Optional.')
    optional_user_options.add_option(
        '--shell', '-s', help='User shell path. Optional.')
    optional_user_options.add_option(
        '--admin', '-a', action='store_true',
        help='User account should be added to admin group.')
    optional_user_options.add_option(
        '--autologin', '-A', action='store_true',
        help='User account should automatically login.')
    optional_user_options.add_option('--hidden', action='store_true',
                                     help='User account should be hidden.')

    parser.add_option_group(required_user_options)
    parser.add_option_group(required_package_options)
    parser.add_option_group(optional_user_options)

    options, arguments = parser.parse_args()

    # verify options and arguments
    required_options = ('name', 'uid', 'version', 'identifier')
    missing_required_options = False
    for option in required_options:
        if not hasattr(options, option) or getattr(options, option) is None:
            print >> sys.stderr, 'Missing required option: %s' % option
            missing_required_options = True
    if missing_required_options:
        parser.print_help()
        exit(-1)

    if len(arguments) != 1:
        print >> sys.stderr, "Must provide exactly one filename!"
        parser.print_help()
        exit(-1)
    filename = arguments[0]

    if options.password:
        password = options.password
    else:
        password = getpass.getpass('Password: ')
        password_again = getpass.getpass('Password (again): ')
        if password != password_again:
            print >> sys.stderr, "Password mismatch!"
            exit(-1)

    # make user plist
    user_data = {'name': options.name,
                 'uid': options.uid,
                 'ShadowHashData': shadowhash.generate(password)}
    if options.fullname:
        user_data['realname'] = options.fullname
    if options.gid:
        user_data['gid'] = options.gid
    if options.generateduid:
        user_data['uuid'] = options.generateduid
    if options.home:
        user_data['home'] = options.home
    if options.shell:
        user_data['shell'] = options.shell
    if options.hidden:
        user_data['IsHidden'] = u'YES'

    user_plist = userplist.generate(user_data)


    # set up package options/choices
    pkg_data = {'version': options.version,
                'pkgid': options.identifier,
                'destination_path': filename,
                'user_plist': user_plist}
    if options.autologin:
        pkg_data['kcpassword'] = kcpassword.generate(password)
    if options.admin:
        pkg_data['is_admin'] = True

    # build the package
    userpkg.generate(pkg_data)


if __name__ == '__main__':
    main()