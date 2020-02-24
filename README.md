# Mercari Skill test project

## This project was developed using MVVM Architectural pattern,

The MVVM design pattern is similar to the well known MVC pattern in that the M (Model) and V (View) are relatively the same. The only difference resides between the C (Controller) and the VM (View Model).

### Model
Represents the Data + State + Business logic. It is not tied to the view nor to the controller, which makes it reusable in many contexts.
### View
Binds to observable variables and actions exposed by the View Model. It is possible for multiple views to bind to a single View Model.
### View Model
Responsible for wrapping the model and preparing observable data needed by the view. It also provides hooks for the view to pass events to the model. An important thing to keep in mind is that the View Model is not tied to the view.

### Data Binding
Introduced in Google I/O 2015, the Data Binding library helps write declarative layouts and minimize the glue code necessary to bind application logic and layouts.

This project also used following components,

### Retrofit
I have used Retrofit as HTTP client for this project.

### RxJava
RxJava was used to subsribe to the API calls and Moshi was used to parse JSON response.

### Dagger 2
Dagger 2 was used as the dependancy injection framework.

### Room
I used Room to save categories in local database and making it available immediately after launching the app.

## UI Automation Testing Using Espresso

I have added some UI automation testcases using Espresso which covers main features of the application. Test project is using a Page Object Model which will make adding new test cases effortless. Also used IdlingResource to validate asynchronous operations more reliably.

