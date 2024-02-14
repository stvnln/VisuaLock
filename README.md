# VisuaLock

## Overview
A password system that utilizes images as passwords instead of the traditional text-based passwords. This login method will be particularly useful for older adults or those prone to forget passwords as images can be remembered easier.
## Tasks To Be Done

- [ ] Login
- [ ] Change Password
- [ ] Image Catalog
- [ ] Change Username
- [ ] Delete Account
- [ ] Forgot Password
- [ ] Change Email
- [ ] Registration
- [ ] Selection of Image Groups
- [ ] Add Image Category
- [ ] Disable Image Selection
- [ ] Add Image to Database
- [ ] Client Interface for Admin
- [ ] Authentication Token
- [ ] Redirect to Admin Site

## Task Descriptions

### ---Login---
#### Introduction:
A prompt for Username/Email and then a screen for image selection/password.
#### Rationale:
Login to access the main page.
#### Input: 
Email and password.

#### Requirement Description: 
The following requirements must be met to allow login.
  - All fields must be filled and completed.
  - The credentials are validated by the database.

### ---Change Password---
#### Introduction: 
An easy system to change a password.
#### Rationale: 
The user may want to change passwords for any reason.
#### Requirement Description: 
All requirements must be met to change password.
  - The user must input the right current password.
  - The new password cannot be the same as the current password.

### ---Image Catalog---
#### Introduction:
The category of images that the user will be presented to choose from, in order to select the unique images that will be used for the graphical password.
#### Rationale: 
To create a unique graphical password, the user's password will be created using images from unique categories.
#### Input: 
Image selection 
#### Requirement Description: 
The user should be able to select images from the image catalog, if they are doing Login/Registration or changing their password. This is only possible if all requirements are met.

  - The user must select the required number of images in each category

### ---Change Username---
#### Introduction: 
The user is given the option in account settings to change their username 
#### Rationale:
The user may want to change their username due to personal reasons; 
#### Inputs:
New username
#### Requirement Description:
The user should be able to change username, if the user is logged into their account. This is only possible if all requirements are met.
All requirements must be met to change username

  - The user must be logged into their account and inside of their account settings
  - The user must enter in a new username that is available

### ---Delete Account---
#### Introduction:
The user is given the option in account settings to delete their account 
#### Rationale: 
The user may not want to utilize the service anymore and decides that they will completely delete their account from the application
#### Inputs:
Email and Password
#### Requirement Description: 
The user should be able to delete accounts once they are signed into their account. This is only possible if all requirements are met.
All requirements must be met to delete account successfully 

  - The user must be logged into their account 
  - The user must confirm their account deletion in account settings 

### ---Forgot Password---
#### Introduction:
A simple way for users that find themselves locked out of their account to provide their email address and change their password to log back into the system. 
#### Rationale: 
The user may have forgotten their password, or simply want to change it due to personal reasons. 
#### Inputs:
Email & (new) Password
#### Requirement Description: 
The user must be able to request a password reset, with the following requirements.

  - The user must provide a valid email address that has been registered in the database.
  - The user must click on the time-sensitive link provided in the password reset email in order to be redirected to the password reset page. 
  - The user must provide a new password that is unique (not currently stored in the database)

### ---Change Email---
#### Introduction:
A simple way for users who wish to change the email address that they use to login to the system. 
#### Rationale: 
The user might prefer having a different email address associated with their account. 
#### Inputs: 
Current Email/Username & Password
#### Requirement Description: 
The user must be logged in, in the settings menu, with all requirements met.

  - The user must provide their current login credentials (username & password) before changing their current email address. 
  - The user must provide a new email address that currently does not exist in the database in order to update it.
  - The user must click on the confirmation link to finalize the change email process.  


### ---Registration---
#### Introduction: 
Easy to use system to register an account with the app.
#### Rationale: 
Registration process for the user to create an account.
#### Inputs:
Username, Email, Password
#### Requirement Description: 
The user should be able to register an account, assuming all requirements are met.

  - The system should prompt the user to enter their desired username, email, and password.
  - The system should validate the uniqueness of the username and email in the database.
  - If the username or email already exists, the system should prompt the user to choose a different one.
  - Upon successful validation, the system should store the registration details in the database.
  - The admin should have access to oversee the registration process and manage the database.

### ---Selection of Image Groups---
#### Introduction:
Simple selection of image categories to determine valid password component images.
#### Rationale: 
Users should be able to decide the sets of images valid for their password, to limit overloading with choices.
#### Inputs: 
Category selection by the user
#### Requirement Description: 
The user should be able to select the image groups for their password.

  - The system should provide the user with several collections of images to choose from.
  - The user should be able to select a predetermined number of categories to form their personalized image group.
  - The system should associate the selected categories with the user's account in the database.
  - The user should have the ability to modify their personalized image group at any time through account settings.

### ---Add Image Category---
#### Introduction: 
Ability to add new categories of images for image groups.
#### Rationale:
Admin should be able to add new image categories to expand the selection.
#### Inputs: 
Admin login, category name
#### Requirement Description:
Admin must be logged in, and able to input category names.

  - Category name must not be empty.
  - Category names must not already be used by the database.

### ---Disable Image Selection---
#### Introduction:
Ability to disable images from being selected for a new password.
#### Rationale: 
Images should be removable in case of an error, but may already be used, so should not be removed completely and will only be disabled from further implementation in passwords.
#### Inputs:
Selection of image/images
#### Requirement Description: 
Admin must be logged in, and able to select images to disable.

  - Admin must be logged in
  - Images must be selected
  - Requires confirmation

### ---Add Image to Database---
#### Introduction: 
Simple method to allow the admin to add new images to be selected for passwords
#### Rationale:
A new image can be added to increase the options provided for passwords.
#### Inputs:
Image and Image Category
#### Requirement Description:
The admin must be able to upload images, with the following requirements.

  - User is logged in as admin.
  - User must provide an image.

### ---Client Interface for Admin---
#### Introduction:
View of the app as seen by the client while logged in to an admin account.
#### Rationale: 
The admin has the capability to view the options given to the clients without having to log in with a client account.
#### Inputs:
Login to admin account, selection in admin panel.
#### Requirement Description:
Must be able to use client view, with the following requirements met.

  - User is logged in as admin
  - Client view is selected

### ---Authentication Token---
#### Introduction:
Quick access to account when already logged in.
#### Rationale: 
The user is able to access their account without logging in, provided they have logged in recently.
#### Inputs:
Enter login page, prior valid login
#### Requirement Description: 
The user must be able to log in normally, and must be verified by the database.

  - User has logged in recently.
  - Database has a valid authentication token.

### ---Redirect to Admin Site---
#### Introduction: 
This feature facilitates seamless redirection to the site that the admin has set.
#### Rationale:
This allows our app to be integrated into other companies to be used as a login system
#### Inputs:
The url provided by the admin and a valid authentication token
#### Requirement Description: 
The user will be redirected to their desired site after providing the correct credentials.

  - User has valid authentication token
  - There is an url provided by the admin

## Completed Tasks

- [x] Sprint 1
- [x] Sprint 2


