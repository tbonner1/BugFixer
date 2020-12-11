import java.util.ArrayList;
//import java.util.Collections;
import java.util.Scanner;

public class Main 
{
    
    static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        /*System.out.println("Hello World!");*/
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();
    }

    private static void optionsSelection() 
    {
        //The other arraylist was redundant
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        
        //Instead of calling the static function recursively use a do while loop
        int options = 6;
        
        do 
        {
            String[] arr = {"1. I wish to review my expenditure","2. I wish to add my expenditure","3. I wish to delete my expenditure","4. I wish to sort the expenditures","5. I wish to search for a particular expenditure","6. Close the application"};
            
            //Slen was redundant
            for(int i=0; i<arr.length;i++)
                System.out.println(arr[i]);
            
            System.out.println("\nEnter your choice:\t");
            
            options =  sc.nextInt();
            
            
            switch (options)
            {
                case 1:
                    System.out.println("Your saved expenses are listed below: \n");
                    System.out.println(expenses+"\n");
                    break;
                case 2:
                    System.out.println("Enter the value to add your Expense: \n");
                    int value = sc.nextInt();
                    expenses.add(value);
                    System.out.println("Your value is updated\n");
                    System.out.println(expenses+"\n");
    
                    break;
                case 3:
                    System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                    int con_choice = sc.nextInt();
                    if(con_choice==options)
                    {
                        expenses.clear();
                        System.out.println(expenses+"\n");
                        System.out.println("All your expenses are erased!\n");
                    } 
                    else 
                    {
                        System.out.println("Oops... try again!");
                    }
                    break;
                case 4:
                    sortExpenses(expenses);
                    break;
                case 5:
                    searchExpenses(expenses);
                    break;
                case 6:
                    closeApp();
                    break;
                default:
                    System.out.println("You have made an invalid choice!");
                    break;
            }
        }
        while(options != 6);
        
        sc.close();
    }
    private static void closeApp() 
    {
        System.out.println("Closing your application... \nThank you!");
    }
    
    //Uses linear search to show if the expense is in arrayList
    private static void searchExpenses(ArrayList<Integer> arrayList) 
    {
        int leng = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        
        int expense = sc.nextInt();
        boolean found = false;
        
        //Linear search
        for(int i = 0; i < leng; i++)
        {
            if (arrayList.get(i) == expense)
            {
                System.out.println("Expense found at position " + i + "\n");
                found = true;
            }
            
            if (!found && i == (leng - 1))
                System.out.println("Expense not found.\n");
            
        }
        
    }
    
    //Sorts expenses using bubble sort 
    private static void sortExpenses(ArrayList<Integer> arrayList) 
    {
        //The easy way
        //Collections.sort(arrayList);
        
        int arrlength =  arrayList.size();
        
        //Bubble Sort
        for (int i = 0; i < arrlength-1; i++) 
            for (int j = 0; j < arrlength-i-1; j++) 
                if (arrayList.get(j) > arrayList.get(j+1)) 
                { 
                    int temp = arrayList.get(j); 
                    arrayList.set(j, arrayList.get(j+1)); 
                    arrayList.set(j+1, temp); 
                } 
        
        System.out.println("Expenses sorted.\n");
    }
}