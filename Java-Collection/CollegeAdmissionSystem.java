import java.util.*;

public class CollegeAdmissionSystem {
    static class Student {
        final String id;
        final double marks;
        Student(String id, double marks){ this.id=id; this.marks=marks; }
        @Override public String toString(){ return id + "(" + marks + ")"; }
        @Override public boolean equals(Object o){ return o instanceof Student && ((Student)o).id.equals(id); }
        @Override public int hashCode(){ return id.hashCode(); }
    }

    public static void main(String[] args) {
        List<Student> applicants = new ArrayList<>();
        applicants.add(new Student("S1", 85));
        applicants.add(new Student("S2", 92));
        applicants.add(new Student("S3", 78));

        // shortlist into Set (unique)
        Set<Student> shortlisted = new HashSet<>();
        for (Student s : applicants) {
            if (s.marks >= 80) shortlisted.add(s);
        }
        System.out.println("Shortlisted: " + shortlisted);

        // Queue for interviews
        Queue<Student> interviewQueue = new LinkedList<>(shortlisted);
        System.out.println("Interview order:");
        while (!interviewQueue.isEmpty()) {
            Student s = interviewQueue.poll();
            System.out.println("Interviewing " + s);
            // decide selection randomly for demo
        }

        // After interviews, add to TreeSet sorted by marks descending
        TreeSet<Student> meritList = new TreeSet<>((a,b)-> {
            int cmp = Double.compare(b.marks, a.marks);
            return cmp != 0 ? cmp : a.id.compareTo(b.id);
        });
        meritList.addAll(shortlisted);
        System.out.println("Final merit list: " + meritList);
    }
}
