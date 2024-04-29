import java.io.IOException;
import java.util.HashMap;

/**
 * Java example to create a HashMap
 * of user defined class type
 */

public class CustomHashMap {
    public static class Student {
        private int rollNo;
        private String name;

        // constructor
        public Student(int rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
        }

        // getter
        public int getRollNo() {
            return this.rollNo;
        }

        public String getName() {
            return this.name;
        }

        // setter
        public void setRollNo(int rollNo) {
            this.rollNo = rollNo;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Overriding the hashcode() method
        @Override
        public int hashCode() {
            /**
             * uses rollNo to verify the uniqueness
             * of the object of Student class
             */
            final int temp = 14;
            int ans = 1;
            ans = temp * ans + rollNo;

            return ans;
        }

        /**
         * Equal objects must produce the same
         * hash code as long as they are equal
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }

            Student other = (Student) o;
            if (this.rollNo != other.rollNo) {
                return false;
            }

            return true;
        }
    }

    // main method
    public static void main(String[] args) throws NumberFormatException, IOException {
        HashMap<Student, String> map = new HashMap<>();

        Student s1 = new Student(1, "wasif");
        Student s2 = new Student(2, "ali");

        // put keys in map
        map.put(s1, s1.getName());
        map.put(s2, s2.getName());

        // changing key state so that
        // hashcode() shuld be calculated again
        s1.setName("md wasif");
        s2.setName("md ali");

        // still prints wasif
        System.out.println(map.get(s1));
        // still print ali
        System.out.println(map.get(s2));

        // try with newly created key with same rollNo
        Student s3 = new Student(1, "md wasif ali");

        // we get wasif
        System.out.println(map.get(s3));
    }
}