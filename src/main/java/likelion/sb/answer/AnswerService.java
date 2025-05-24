package likelion.sb.answer;
import likelion.sb.DataNotFoundException;
import likelion.sb.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import likelion.sb.user.SiteUser;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service

public class AnswerService {
    private final AnswerRepository answerRepository;

    public void modify(Answer answer, String content) {
        // 답변 수정 로직 구현
    }
    public void vote(Answer answer, SiteUser siteUser) {
        answer.getVoter().add(siteUser); // Set<SiteUser> voter;
        answerRepository.save(answer);
    }
    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }

    public Answer getAnswer(Integer id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Answer not found"));
    }

    public Answer create(Question question, String content,SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
        return answer;
    }
}
