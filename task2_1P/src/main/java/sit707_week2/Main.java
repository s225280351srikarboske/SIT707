package sit707_week2;

public class Main 
{
    public static void main(String[] args)
    {
        SeleniumOperations.officeworks_registration_page(
            "https://www.officeworks.com.au/app/identity/create-account"
        );

        SeleniumOperations.footlocker_registration(
"https://www.footlocker.com.au/en/account/create"        );

        System.out.println("Both tasks completed!");
    }
}