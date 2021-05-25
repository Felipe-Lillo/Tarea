package testClases.QanovaClases;

import Utils.ReadProperties;
import page.QAnova.Tabla;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnviarMail {
    /**
     * Creación del metodo para poder enviar los correos via GMAIL, Con sus caracteristicas y demas, hay que hacer ajustes em el correo y instalar JAVA MAIL
     */
    public void enviarMensange() throws InterruptedException {
        Tabla tabla = new Tabla();
        Properties propiedad = new Properties();

        propiedad.put("mail.smtp.host", "smtp.gmail.com");
        propiedad.put("mail.smtp.starttls.enable", "true");
        propiedad.put("mail.smtp.port", 587);
        propiedad.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(propiedad);

        String correoEnviar = ReadProperties.readFromConfig("Properties.properties").getProperty("correoEmisor");
        String contrasena = ReadProperties.readFromConfig("Properties.properties").getProperty("claveEmisor");
        String destinatario = ReadProperties.readFromConfig("Properties.properties").getProperty("correoReceptor");
        String asunto = ReadProperties.readFromConfig("Properties.properties").getProperty("asuntoMail");

        String mensaje = tabla.recuperarDatosTabla();

        MimeMessage mail = new MimeMessage(session);

        try {
            mail.setFrom(new InternetAddress(correoEnviar));
            mail.addRecipients(Message.RecipientType.TO, destinatario);
            mail.setSubject(asunto);
            mail.setText(mensaje);

            Transport transporte = session.getTransport("smtp");
            transporte.connect(correoEnviar, contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}


