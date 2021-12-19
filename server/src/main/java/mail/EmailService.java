package mail;

import mail.message.AttachmentMailMessage;
import mail.message.EmailMessage;


public interface EmailService {
    void send(EmailMessage message);
    void send(AttachmentMailMessage message);
}