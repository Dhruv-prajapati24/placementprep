package com.placementprep;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.placementprep.entity.DSAQuestion;
import com.placementprep.entity.Question;
import com.placementprep.repository.DSARepository;
import com.placementprep.repository.QuestionRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final QuestionRepository questionRepository;
    private final DSARepository dsaRepository;

    public DataLoader(QuestionRepository questionRepository,
                      DSARepository dsaRepository) {
        this.questionRepository = questionRepository;
        this.dsaRepository = dsaRepository;
    }

    @Override
    public void run(String... args) {

        // ================= Aptitude Questions =================
        if (questionRepository.count() == 0) {

            Question q1 = new Question();
            q1.setQuestion("A train 120 m long crosses a pole in 6 seconds. What is its speed?");
            q1.setOptionA("60 km/h");
            q1.setOptionB("72 km/h");
            q1.setOptionC("80 km/h");
            q1.setOptionD("90 km/h");
            q1.setCorrectAnswer("72 km/h");
            questionRepository.save(q1);

            Question q2 = new Question();
            q2.setQuestion("A shopkeeper gives a 20% discount on a ₹500 item. What is the selling price?");
            q2.setOptionA("₹350");
            q2.setOptionB("₹380");
            q2.setOptionC("₹400");
            q2.setOptionD("₹420");
            q2.setCorrectAnswer("₹400");
            questionRepository.save(q2);

            Question q3 = new Question();
            q3.setQuestion("The ratio of boys to girls in a class is 3:2. If there are 18 boys, how many girls are there?");
            q3.setOptionA("10");
            q3.setOptionB("12");
            q3.setOptionC("14");
            q3.setOptionD("16");
            q3.setCorrectAnswer("12");
            questionRepository.save(q3);

            Question q4 = new Question();
            q4.setQuestion("A man covers 240 km in 4 hours. What is his average speed?");
            q4.setOptionA("50 km/h");
            q4.setOptionB("55 km/h");
            q4.setOptionC("60 km/h");
            q4.setOptionD("65 km/h");
            q4.setCorrectAnswer("60 km/h");
            questionRepository.save(q4);

            Question q5 = new Question();
            q5.setQuestion("If the cost price of an item is ₹800 and it is sold for ₹920, what is the profit percentage?");
            q5.setOptionA("12%");
            q5.setOptionB("15%");
            q5.setOptionC("18%");
            q5.setOptionD("20%");
            q5.setCorrectAnswer("15%");
            questionRepository.save(q5);

            Question q6 = new Question();
            q6.setQuestion("A person invests ₹10,000 at 10% simple interest for 2 years. What is the total amount?");
            q6.setOptionA("₹11,500");
            q6.setOptionB("₹12,000");
            q6.setOptionC("₹12,200");
            q6.setOptionD("₹13,000");
            q6.setCorrectAnswer("₹12,000");
            questionRepository.save(q6);

            Question q7 = new Question();
            q7.setQuestion("Find the next number in the series: 3, 6, 11, 18, 27, ?");
            q7.setOptionA("36");
            q7.setOptionB("38");
            q7.setOptionC("40");
            q7.setOptionD("42");
            q7.setCorrectAnswer("38");
            questionRepository.save(q7);

            Question q8 = new Question();
            q8.setQuestion("If 12 workers complete a job in 15 days, how many days will 20 workers take?");
            q8.setOptionA("8");
            q8.setOptionB("9");
            q8.setOptionC("10");
            q8.setOptionD("12");
            q8.setCorrectAnswer("9");
            questionRepository.save(q8);

            Question q9 = new Question();
            q9.setQuestion("Choose the correct synonym of 'Rapid'.");
            q9.setOptionA("Slow");
            q9.setOptionB("Fast");
            q9.setOptionC("Weak");
            q9.setOptionD("Calm");
            q9.setCorrectAnswer("Fast");
            questionRepository.save(q9);

            Question q10 = new Question();
            q10.setQuestion("If all Roses are Flowers and some Flowers are Red, which statement is definitely true?");
            q10.setOptionA("All Roses are Red");
            q10.setOptionB("Some Roses are Red");
            q10.setOptionC("All Roses are Flowers");
            q10.setOptionD("No Flower is Red");
            q10.setCorrectAnswer("All Roses are Flowers");
            questionRepository.save(q10);
        }

        // ================= DSA Questions =================
        if (dsaRepository.count() == 0) {

            DSAQuestion d1 = new DSAQuestion();
            d1.setTopic("Arrays");
            d1.setQuestion("Two Sum");
            d1.setDifficulty("Easy");
            d1.setCompleted(false);
            d1.setLeetcodeLink("https://leetcode.com/problems/two-sum/");
            d1.setYoutubeLink("https://youtu.be/KLlXCFG5TnA");
            d1.setNotes("Use HashMap for O(n) solution.");
            dsaRepository.save(d1);

            DSAQuestion d2 = new DSAQuestion();
            d2.setTopic("Arrays");
            d2.setQuestion("Best Time to Buy and Sell Stock");
            d2.setDifficulty("Easy");
            d2.setCompleted(false);
            d2.setLeetcodeLink("https://leetcode.com/problems/best-time-to-buy-and-sell-stock/");
            d2.setYoutubeLink("https://youtu.be/1pkOgXD63yU");
            d2.setNotes("Track minimum price while traversing.");
            dsaRepository.save(d2);

            DSAQuestion d3 = new DSAQuestion();
            d3.setTopic("Strings");
            d3.setQuestion("Valid Anagram");
            d3.setDifficulty("Easy");
            d3.setCompleted(false);
            d3.setLeetcodeLink("https://leetcode.com/problems/valid-anagram/");
            d3.setYoutubeLink("https://youtu.be/9UtInBqnCgA");
            d3.setNotes("Count frequency of characters.");
            dsaRepository.save(d3);

            DSAQuestion d4 = new DSAQuestion();
            d4.setTopic("Linked List");
            d4.setQuestion("Reverse Linked List");
            d4.setDifficulty("Easy");
            d4.setCompleted(false);
            d4.setLeetcodeLink("https://leetcode.com/problems/reverse-linked-list/");
            d4.setYoutubeLink("https://youtu.be/G0_I-ZF0S38");
            d4.setNotes("Use three pointers.");
            dsaRepository.save(d4);

            DSAQuestion d5 = new DSAQuestion();
            d5.setTopic("Trees");
            d5.setQuestion("Maximum Depth of Binary Tree");
            d5.setDifficulty("Easy");
            d5.setCompleted(false);
            d5.setLeetcodeLink("https://leetcode.com/problems/maximum-depth-of-binary-tree/");
            d5.setYoutubeLink("https://youtu.be/hTM3phVI6YQ");
            d5.setNotes("Solve using DFS recursion.");
            dsaRepository.save(d5);
        }

        System.out.println("✅ Aptitude & DSA Questions Inserted Successfully!");
    }
}