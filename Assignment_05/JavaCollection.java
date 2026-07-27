import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class JavaCollection {

    public static void main(String[] args) {

        System.out.println("===== Array Example =====");
        ArrayExample.main(args);

        System.out.println("\n===== ArrayList Example =====");
        ArrayListExample.main(args);

        System.out.println("\n===== Vector Example =====");
        VectorExample.main(args);

        System.out.println("\n===== String Example =====");
        StringExample.main(args);

        System.out.println("\n===== StringBuffer Example =====");
        StringBufferExample.main(args);

        System.out.println("\n===== StringTokenizer Example =====");
        StringTokenizerExample.main(args);
    }
}

// =========================
// Array Example
// =========================
class ArrayExample {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Array Elements:");

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}

// =========================
// ArrayList Example
// =========================
class ArrayListExample {

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("ArrayList: " + fruits);

        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);

        System.out.println("Size: " + fruits.size());

        System.out.println("Contains Apple? " + fruits.contains("Apple"));

        fruits.remove("Apple");
        fruits.remove("Cherry");

        System.out.println("After removing all elements: " + fruits);
    }
}

// =========================
// Vector Example
// =========================
class VectorExample {

    public static void main(String[] args) {

        Vector<Integer> numbersVector = new Vector<>();

        numbersVector.add(100);
        numbersVector.add(200);
        numbersVector.add(300);

        System.out.println("Vector: " + numbersVector);

        numbersVector.remove(1);
        System.out.println("After removing index 1: " + numbersVector);

        System.out.println("Size: " + numbersVector.size());

        System.out.println("Element at index 0: " + numbersVector.get(0));

        numbersVector.add(400);
        System.out.println("After adding 400: " + numbersVector);

        System.out.println("Contains 300? " + numbersVector.contains(300));

        System.out.println("Capacity: " + numbersVector.capacity());
    }
}

// =========================
// String Example
// =========================
class StringExample {

    public static void main(String[] args) {

        String str1 = "Hello";
        str1 = "Student";

        String str2 = new String("Java");

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        System.out.println("Length: " + str1.length());

        System.out.println("Uppercase: " + str1.toUpperCase());

        System.out.println("Lowercase: " + str1.toLowerCase());

        System.out.println("Character at index 2: " + str1.charAt(2));

        System.out.println("Substring (1,4): " + str1.substring(1, 4));

        System.out.println("Equals 'Student'? " + str1.equals("Student"));

        System.out.println("Contains 'den'? " + str1.contains("den"));

        System.out.println("Replace: " + str1.replace("Student", "Java"));
    }
}

// =========================
// StringBuffer Example
// =========================
class StringBufferExample {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Hello World!");

        System.out.println("Original: " + sb);

        sb.append(" Hi");
        System.out.println("After Append: " + sb);

        sb.insert(6, "Java ");
        System.out.println("After Insert: " + sb);

        sb.replace(0, 5, "Hi");
        System.out.println("After Replace: " + sb);

        sb.delete(2, 7);
        System.out.println("After Delete: " + sb);

        sb.reverse();
        System.out.println("After Reverse: " + sb);

        sb.reverse();

        System.out.println("Capacity: " + sb.capacity());

        System.out.println("Length: " + sb.length());

        System.out.println("Character at index 1: " + sb.charAt(1));

        sb.setCharAt(1, 'A');
        System.out.println("After setCharAt(): " + sb);

        sb.deleteCharAt(1);
        System.out.println("After deleteCharAt(): " + sb);
    }
}

// =========================
// StringTokenizer Example
// =========================
class StringTokenizerExample {

    public static void main(String[] args) {

        String str = "Java,Python,C++,JavaScript";

        StringTokenizer st = new StringTokenizer(str, ",");

        System.out.println("Tokens:");

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
