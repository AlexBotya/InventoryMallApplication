package mail.message;



public record EmailMessage(String from, String to, String subject, String text) {
}