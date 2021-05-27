package Calculator;

import java.util.Scanner;

public class Calculator
{
    private static boolean its_an_arabic_numbers = true;

    private static String[] pars(String input)
    {
        String[] parsed_input = input.split(" ");
        if (parsed_input.length != 3)
        {
            Scanner input_a_value_again = new Scanner(System.in);
            System.out.println("Enter an expression, separating each character with a _space_");
            input = input_a_value_again.nextLine();
            return pars(input);
        } else
        {
            return parsed_input;
        }
    }


    public static void main(String[] args)
    {

        Scanner input_a_value = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String input = input_a_value.nextLine();
        while (!input.isEmpty())
        {
            String[] parsed_input = Calculator.pars(input);
            String operation = parsed_input[1];
            Number values;
            int value1 = 0;
            int value2 = 0;
            try {
                value1 = Integer.parseInt(parsed_input[0]);
                value2 = Integer.parseInt(parsed_input[2]);
                //values = new Arabic(value1, value2, 0);
                }
            catch (NumberFormatException e)
                 {
                its_an_arabic_numbers = false;
                 }

            if (its_an_arabic_numbers)
                {
                values = new Arabic(value1, value2);
                }
                    else
                    {
                        values = new Romes(parsed_input[0], parsed_input[2]);
                    }

            switch (operation)
            {
                case "+" -> values.sum();
                case "-" -> values.sub();
                case "/", ":" -> values.div();
                case "*", "x" -> values.mul();
            }

            if (its_an_arabic_numbers)
                {
                System.out.println("Answer: " + values.getResult());
                }
                    else
                    {
                        System.out.println("Answer: " + values.getStringResult());
                        its_an_arabic_numbers = true;
                    }
        System.out.println();
        System.out.print("Enter an next expression: ");
        input = input_a_value.nextLine();
        }

    }
}
