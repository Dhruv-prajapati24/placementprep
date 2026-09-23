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
            q1.setQuestion("2 + 2 = ?");
            q1.setOptionA("3");
            q1.setOptionB("4");
            q1.setOptionC("5");
            q1.setOptionD("6");
            q1.setCorrectAnswer("4");
            questionRepository.save(q1);

            Question q2 = new Question();
            q2.setQuestion("5 × 6 = ?");
            q2.setOptionA("25");
            q2.setOptionB("30");
            q2.setOptionC("35");
            q2.setOptionD("40");
            q2.setCorrectAnswer("30");
            questionRepository.save(q2);

            Question q3 = new Question();
            q3.setQuestion("Capital of India?");
            q3.setOptionA("Mumbai");
            q3.setOptionB("Delhi");
            q3.setOptionC("Chennai");
            q3.setOptionD("Kolkata");
            q3.setCorrectAnswer("Delhi");
            questionRepository.save(q3);

            Question q4 = new Question();
            q4.setQuestion("Square root of 144?");
            q4.setOptionA("10");
            q4.setOptionB("11");
            q4.setOptionC("12");
            q4.setOptionD("13");
            q4.setCorrectAnswer("12");
            questionRepository.save(q4);

            Question q5 = new Question();
            q5.setQuestion("15% of 200 = ?");
            q5.setOptionA("20");
            q5.setOptionB("25");
            q5.setOptionC("30");
            q5.setOptionD("35");
            q5.setCorrectAnswer("30");
            questionRepository.save(q5);
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