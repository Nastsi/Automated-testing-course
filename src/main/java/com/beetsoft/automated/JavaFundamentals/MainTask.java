package com.beetsoft.automated.JavaFundamentals;


import java.util.Scanner;

public class MainTask {

    class Order
    {
        private int orderNumber;
        private int clientNumber;
        private Pizza[] pizza;

        Order()
        {

        }

        Order(int orderNumber, int clientNumber, Pizza[] pizza)
        {
            this.orderNumber = orderNumber;
            this.clientNumber = clientNumber;
            this.pizza = pizza;
        }

        public void showPizzaAttribute(int number)
        {
            System.out.print("[" + orderNumber + " : " + clientNumber + " : " + pizza[number].pizzaName + " : "  + pizza[number].quantity + "]");
        }

        public void changeQuantity(Order order, String pizzaName, int quantity)
        {
            for (int i = 0; i < order.pizza.length; i++)
            {
                if (order.pizza[i].pizzaName.compareTo(pizzaName) == 0)
                {
                    if (quantity != 0)
                    {
                        order.pizza[i].quantity = quantity;
                        break;
                    }
                    else
                    {
                        for (int j = i; j < order.pizza.length; j++)
                        {
                            order.pizza[j].pizzaName = order.pizza[i].pizzaName;
                            order.pizza[j].ingredients = order.pizza[i].ingredients;
                            order.pizza[j].pizzaType = order.pizza[i].pizzaType;
                            order.pizza[j].quantity = order.pizza[i].quantity;
                        }
                        break;
                    }
                }
            }
        }
    }

    class Pizza
    {
        private String pizzaName;
        private String[] ingredients;
        private String pizzaType;
        private int quantity;

        Pizza(String pizzaName, String pizzaType, int quantity)
        {
            this.pizzaName = pizzaName;
            this.pizzaType = pizzaType;
            this.quantity = quantity;
        }

        Pizza()
        {

        }
    }

    public static String checkPizzaName(String name, int clientNumber, int number)
    {
        String pizzaName;

        if (name.length() < 4 || name.length() > 20)
        {
            pizzaName = clientNumber + "_" + number;
        }
        else pizzaName = name;

        return pizzaName;
    }

    public void main(String[] args)
    {
        int firstNumberOrder = 10000;
        int firstClientNumber = 1;
        Pizza pizza = new Pizza();
        Order order = new Order();

        String answer;
        String pizzaName;
        int quantity;

        System.out.println("Do you want to change quantity of your pizzas? Y/N");
        Scanner in = new Scanner(System.in);
        answer = in.next();
        System.out.println();

        if (answer == "Y")
        {
            System.out.print("Enter pizza's name: ");
            pizzaName = in.next();
            System.out.println();
            System.out.print("Enter quantity: ");
            quantity = in.nextInt();
            order.changeQuantity(order, pizzaName, quantity);
        }

    }
}
