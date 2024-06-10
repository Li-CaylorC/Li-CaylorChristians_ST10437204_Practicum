# Li-CaylorChristians_ST10437204_Practicum
Weather app using Kotlin  in Android Studio  
step 1: Navigate to the Google Play Store on your Android device.
step 2: Locate the MyWeatherApp in the search results and tap on it, Click the "Install" button to download and install the app on your device.
step 3: Tap on the icon to launch the app.
step 4: Once the app is launched, you'll see the UI design/screen 1 , which indicates the name and logo of the app and two button 1: to parse to next page 2:to exit the app
step 5: youll now be in main screen page/screen 2 ; Enter the day, minimum temperature, maximum temperature, and weather condition in the respective fields, Tap on the "Add Data" button to save the entered data.or clear button incase you have made a mistake 
step 6: To view the summary of the entered weather data, tap on the "View Summary" button, The app will display a summary containing the entered weather information for each day on screen 3.
Thank you for downloading my app! Enjoy! 

purpose of the app: Users of the app can monitor and manage their daily weather conditions for the week. The primary objective is to help users manage weekly weather conditions. I created this native Android app using Kotlin within Android Studio, starting with an empty activity view. The first step was designing the layout for the initial screen, followed by coding the functionality. I tested the app using both the emulator and GitHub, utilizing GitHub Actions for automated testing to ensure the application is maintainable.


pesudocode:
 start
     Declarations
    num Min 
    num Max
    string strDay 
    string strWeatherCondition 
    int attempts = 0

    // Inserting a day 
    output "Please enter a day of the week"
    input "strDay"
    
    while (attempts < 4)  // Changed 0 to 4 as it seems to be the intended number of attempts
        input "option"  // Assuming there's an option for the user to select
        
        if option == 1 then
            output "Input data is saved"
        else if option == 2 then 
            output "Please fill all fields correctly"
        else if option == 3 then
            output "Clear up your data entered"
        else if option == 4 then
            output "Exit the app"
            stop
        end if
        
        attempts = attempts + 1
    end while
stop
