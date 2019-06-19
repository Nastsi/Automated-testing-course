package com.beetsoft.automated.JavaFundamentals;


import java.util.Scanner;

public class MainTask {

    public static String cheese = "Cheese";
    public static String salami = "Salami";
    public static String bacon = "Bacon";
    public static String garlic = "Garlic";
    public static String corn = "Corn";
    public static String pepperoni = "Pepperoni";
    public static String olives = "Olives";
    public static String tomatoPaste = "Tomato Paste";

    public static int orderNumber = 9999;
    public static int clientNumber = 0;

    static class Order
    {
        private int orderNumber;
        private int clientNumber;
        private Pizza[] pizza;

        Order()
        {
            this.pizza = new Pizza[10];
        }

        Order(int orderNumber, int clientNumber)
        {
            this.orderNumber = orderNumber;
            this.clientNumber = clientNumber;
            this.pizza = new Pizza[10];
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

    static class Pizza
    {
        private String pizzaName;
        private String[] ingredients;
        private String pizzaType;
        private int quantity;

        Pizza(String pizzaName, String pizzaType, int quantity)
        {
            this.pizzaName = pizzaName;
            this.ingredients = new String[7];
            this.pizzaType = pizzaType;
            this.quantity = quantity;
        }

        Pizza()
        {
            this.ingredients = new String[8];
        }

        public void addIngredient(Order order, int pizzaNumber, int ingredientNumber, String ingredient)
        {
            boolean exist = false;

            for (int i = 0; i < order.pizza[pizzaNumber].ingredients.length; i++)
            {
                if (order.pizza[pizzaNumber].ingredients[i] != null)
                {
                    if (order.pizza[pizzaNumber].ingredients[i].compareTo(ingredient) == 0) {
                        System.out.println();
                        System.out.println("Please, check your order. You've added this ingredient before.");
                        exist = true;
                        break;
                    }
                }
            }

            if (exist == false) {
                ingredients[ingredientNumber] = ingredient;
            }
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

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        orderNumber++;
        clientNumber++;

        int pizzaNumber = -1;
        int ingredientNumber = -1;

        Order order = new Order(orderNumber, clientNumber);

        String answerAddPizza;
        String answer;
        int answerInt;
        String pizzaName;
        int quantity;

        do {
            System.out.println("Do you want to add pizza to your order? Y/N");
            answerAddPizza = in.next();

            if (answerAddPizza.compareTo("Y") == 0)
            {
                pizzaNumber++;
                order.pizza[pizzaNumber] = new Pizza();
                do {
                    System.out.println();
                    System.out.println("Do you want to add ingredient? Y/N");
                    answer = in.next();
                    System.out.println();

                    if (answer.compareTo("Y") == 0) {
                        System.out.println("Choose one of the ingredient: ");
                        System.out.println("1. Cheese");
                        System.out.println("2. Salami");
                        System.out.println("3. Bacon");
                        System.out.println("4. Garlic");
                        System.out.println("5. Corn");
                        System.out.println("6. Pepperoni");
                        System.out.println("7. Olives");
                        System.out.println("8. Tomato Paste");
                        System.out.println("0. If you've changed your mind and want to leave this step.");
                        System.out.print("Enter a number: ");
                        answerInt = in.nextInt();

                        switch (answerInt) {
                            case 1:
                                ingredientNumber++;
                                order.pizza[pizzaNumber].addIngredient(order, pizzaNumber, ingredientNumber, cheese);
                                break;
                            case 2:
                                ingredientNumber++;
                                order.pizza[pizzaNumber].addIngredient(order, pizzaNumber, ingredientNumber, salami);
                                break;
                            case 3:
                                ingredientNumber++;
                                order.pizza[pizzaNumber].addIngredient(order, pizzaNumber, ingredientNumber, bacon);
                                break;
                            case 4:
                                ingredientNumber++;
                                order.pizza[pizzaNumber].addIngredient(order, pizzaNumber, ingredientNumber, garlic);
                                break;
                            case 5:
                                ingredientNumber++;
                                order.pizza[pizzaNumber].addIngredient(order, pizzaNumber, ingredientNumber, corn);
                                break;
                            case 6:
                                ingredientNumber++;
                                order.pizza[pizzaNumber].addIngredient(order, pizzaNumber, ingredientNumber, pepperoni);
                                break;
                            case 7:
                                ingredientNumber++;
                                order.pizza[pizzaNumber].addIngredient(order, pizzaNumber, ingredientNumber, olives);
                                break;
                            case 8:
                                ingredientNumber++;
                                order.pizza[pizzaNumber].addIngredient(order, pizzaNumber, ingredientNumber, tomatoPaste);
                                break;
                            case 0:
                                break;
                        }
                    }
                }while(answer.compareTo("N") != 0);

                System.out.println();
                System.out.println("Enter your pizza's name: ");
                pizzaName = in.next();
                order.pizza[pizzaNumber].pizzaName = checkPizzaName(pizzaName, clientNumber, pizzaNumber);
            }
        }while(answerAddPizza.compareTo("N") != 0);

        System.out.println("Do you want to change quantity of your pizzas? Y/N");
        answer = in.nextLine();
        System.out.println();

        if (answer == "Y") {
            System.out.print("Enter pizza's name: ");
            pizzaName = in.next();
            System.out.println();
            System.out.print("Enter quantity: ");
            quantity = in.nextInt();
            order.changeQuantity(order, pizzaName, quantity);
        }
    }
}
