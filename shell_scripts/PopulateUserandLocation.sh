#!/bin/sh

# Grab the username of the user that last logged in (current user).
currentUser=`defaults read /Library/Preferences/com.apple.loginwindow lastUserName`

# Submit an inventory report and include the current user (above) to be written to the
# username field in User and Location Information.
jamf recon -endUsername $currentUser

exit 0