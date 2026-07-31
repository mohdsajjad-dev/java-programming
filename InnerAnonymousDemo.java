class Outer {
    private String message = "Hello from the Outer Class";

    // Inner Class
    class Inner {
        void display() {
            System.out.println("Message: " + message);
        }
    }
}

class Animal {

    void sound() {
        System.out.println("Animal makes a sound.");
    }

    // Inner Class
    class Dog {
        void show() {
            System.out.println("Dog is an Inner Class.");
        }
    }
}

public class InnerAnonymousDemo {

    public static void main(String[] args) {

        // Demonstrating Inner Class
        Outer obj = new Outer();
        Outer.Inner in = obj.new Inner();
        in.display();

        Animal a = new Animal();
        Animal.Dog d = a.new Dog();
        d.show();

        // Demonstrating Anonymous Class
        Animal anonymousAnimal = new Animal() {
            void sound() {
                System.out.println("Anonymous Class: Dog is barking.");
            }
        };

        anonymousAnimal.sound();
    }
}