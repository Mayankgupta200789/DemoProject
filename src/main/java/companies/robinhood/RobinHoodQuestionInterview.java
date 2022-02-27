package companies.robinhood;/* You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting should be scheduled when a student has completed 50% of their academic program.

Each course at our university has at most one prerequisite that must be taken first. No two courses share a prerequisite. There is only one path through the program.

Write a function that takes a list of (prerequisite, course) pairs, and returns the name of the course that the student will be taking when they are halfway through their program. (If a track has an even number of courses, and therefore has two "middle" courses, you should return the first one.)

Sample input 1: (arbitrarily ordered)
prereqs_courses1 = [
	["Foundations of Computer Science", "Operating Systems"],
	["Data Structures", "Algorithms"],
	["Computer Networks", "Computer Architecture"],
	["Algorithms", "Foundations of Computer Science"],
	["Computer Architecture", "Data Structures"],
	["Software Design", "Computer Networks"]
]

In this case, the order of the courses in the program is:
	Software Design
	Computer Networks
	Computer Architecture
	Data Structures
	Algorithms
	Foundations of Computer Science
	Operating Systems

Sample output 1:
	"Data Structures"


Sample input 2:
prereqs_courses2 = [
    ["Algorithms", "Foundations of Computer Science"],
    ["Data Structures", "Algorithms"],
    ["Foundations of Computer Science", "Logic"],
    ["Logic", "Compilers"],
    ["Compilers", "Distributed Systems"],
]

Data structures
algorithms
computer science
logic
compilers
distributed


Sample output 2:
	"Foundations of Computer Science"

Sample input 3:
prereqs_courses3 = [
	["Data Structures", "Algorithms"],
]


Sample output 3:
	"Data Structures"

Complexity analysis variables:

n: number of pairs in the input
 */


import java.io.*;
import java.util.*;

public class RobinHoodQuestionInterview {
    public static void main(String[] argv) {
        String[][] prereqsCourses1 = {
                {"Foundations of Computer Science", "Operating Systems"},
                {"Data Structures", "Algorithms"},
                {"Computer Networks", "Computer Architecture"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Computer Architecture", "Data Structures"},
                {"Software Design", "Computer Networks"}
        };



        String[][] prereqsCourses2 = {
                {"Algorithms", "Foundations of Computer Science"},
                {"Data Structures", "Algorithms"},
                {"Foundations of Computer Science", "Logic"},
                {"Logic", "Compilers"},
                {"Compilers", "Distributed Systems"},
        };


        String[][] prereqsCourses3 = {
                {"Data Structures", "Algorithms"}
        };
        System.out.println("the middle value is " + rank(prereqsCourses1));
        System.out.println("the middle value is " + rank(prereqsCourses2));
        System.out.println("the middle value is " + rank(prereqsCourses3));


    }

    public static String rank(String[][] inputs ) {

        Map<String,Integer> degree = new HashMap<>();

        Map<String,List<String>> graph = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        for (String[] value : inputs) {

            graph.put(value[0], new ArrayList<>());

            if (!graph.containsKey(value[1])) {
                graph.put(value[1], new ArrayList<>());
            }


        }

        for (String[] strings : inputs) {

            degree.put(strings[0], degree.getOrDefault(strings[0], 0) + 1);
            graph.get(strings[1]).add(strings[0]);
        }

        for (String[] input : inputs) {

            if (!degree.containsKey(input[1])) {
                degree.put(input[1], 0);
                queue.add(input[1]);
                result.add(0, input[1]);

            }
        }

        while(!queue.isEmpty()) {

            String course = queue.poll();

            for(int i =0 ; i < graph.get(course).size(); i++ ) {

                String output = graph.get(course).get(i);

                degree.put(output, degree.getOrDefault(output,0) - 1);

                if(degree.get(output) == 0 ) {
                    queue.add(output);

                }

                if(!result.contains(output) && degree.get(output) == 0 ) {

                    result.add(0,output);
                }
            }

        }



        int middleIndex = result.size() % 2 == 0 ? (result.size() / 2) - 1 : result.size()/2;

        return  result.get(middleIndex);



    }




}
