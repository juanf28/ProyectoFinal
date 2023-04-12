package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;

public class EmailServicioImpl implements EmailServicio {

    private final JavaMailSender javaMailSender;
    @Override
    public void enviarEmail(EmailDTO emailDTO) throws Exception{
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        try{
            helper.setSubject(emailDTO.getAsunto());
            helper.setText(emailDTO.getCuerpo(), true);
            helper.setTo(emailDTO.getDestinatario());
            helper.setFrom("no_reply@dominio.com");
            javaMailSender.send(mensaje);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
