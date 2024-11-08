## Features

Navigation: Simple and structured navigation flow using NavHost for seamless screen transitions.
Login and Registration Validation: Provides email and password validation with visual error feedback for users.
Dynamic Button States: Sign-in and Sign-up buttons are enabled only when the input fields meet the required criteria.
Log Out Confirmation: Users are prompted with a confirmation dialog before logging out from the homepage.

## Project Structure

Navigation.kt: Defines the navigation graph using NavHost, including routes for Main, SignIn, SignUp, and Homepage screens.
MainScreen: The entry screen where users can choose to Sign In or Sign Up.
SignInScreen: Screen with email and password fields for user sign-in. Validates input fields before enabling the "Continue" button.
SignUpScreen: Screen for user registration, including validation for name, email, and password.
HomepageScreen: Displays homepage content with a log-out button that triggers a confirmation dialog.
EditTextField: Custom reusable text input field component with validation feedback.

## Technologies Used

Kotlin: Primary language used for Android development.
Jetpack Compose: Modern toolkit for building native UI in Android, offering flexibility and ease of use.
Material Design 3: Used for a modern UI design with a cohesive visual language.
Navigation Component: Manages navigation between different screens smoothly.
Pattern Matching: Email validation uses Android's built-in Patterns library.

