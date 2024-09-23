package com.Invitemee.Invitemee.stripe.handleStripeWebhook.inviteTypeConstants;

import org.springframework.stereotype.Component;


public class InviteTypeConstants {
    public static String getLoveContent(String qrCodeUrl) {
        return String.format(
                "<!DOCTYPE html>" +
                        "<html lang=\"en\">" +
                        "<head>" +
                        "    <meta charset=\"UTF-8\">" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                        "    <style>" +
                        "        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #ffe6f0; margin: 0; padding: 0; }" +
                        "        .email-container { background-color: #ffffff; width: 100%%; max-width: 600px; margin: 20px auto; border-radius: 12px; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2); overflow: hidden; }" +
                        "        .header { background-color: #ff6f61; color: #ffffff; padding: 20px; text-align: center; border-bottom: 5px solid #ff3e4d; }" +
                        "        .header h1 { margin: 0; font-size: 26px; }" +
                        "        .body { padding: 30px; text-align: center; }" +
                        "        .body h2 { color: #333; font-size: 22px; }" +
                        "        .body p { color: #666; line-height: 1.6; font-size: 16px; }" +
                        "        .qr-code { margin: 20px 0; }" +
                        "        .qr-code img { width: 150px; height: 150px; border: 2px solid #ff6f61; border-radius: 8px; }" +
                        "        .footer { background-color: #ff6f61; color: #ffffff; padding: 10px; text-align: center; font-size: 12px; }" +
                        "        .button { background-color: #ff6f61; color: #ffffff; padding: 10px 20px; border-radius: 5px; text-decoration: none; font-weight: bold; }" +
                        "    </style>" +
                        "</head>" +
                        "<body>" +
                        "    <div class=\"email-container\">" +
                        "        <div class=\"header\">" +
                        "            <h1>Obrigado pelo seu carinho!</h1>" +
                        "        </div>" +
                        "        <div class=\"body\">" +
                        "            <h2>Olá, amor!</h2>" +
                        "            <p>Agradecemos de coração pela sua compra. Use o QR Code abaixo para acessar seu produto especial.</p>" +
                        "            <div class=\"qr-code\">" +
                        "                <img src=\"%s\" alt=\"QR Code\">" +
                        "            </div>" +
                        "            <p>Se precisar de algo, estamos sempre aqui para ajudar.</p>" +
                        "        </div>" +
                        "        <div class=\"footer\">" +
                        "            <p>&copy; 2024 Invitemee. Todos os direitos reservados. Com amor!</p>" +
                        "        </div>" +
                        "    </div>" +
                        "</body>" +
                        "</html>",
                qrCodeUrl);

    }
    public static String getBirthdayContent(String qrCodeUrl) {
        return String.format(
                "<!DOCTYPE html>" +
                        "<html lang='en'>" +
                        "<head>" +
                        "    <meta charset='UTF-8'>" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                        "    <style>" +
                        "        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }" +
                        "        .email-container { background-color: #ffffff; width: 100%%; max-width: 600px; margin: 20px auto; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); overflow: hidden; }" +
                        "        .header { background-color: #ffcc00; color: #ffffff; padding: 20px; text-align: center; }" +
                        "        .header h1 { margin: 0; font-size: 24px; color: #333; }" +
                        "        .body { padding: 30px; text-align: center; }" +
                        "        .body h2 { color: #333; }" +
                        "        .body p { color: #666; line-height: 1.6; }" +
                        "        .qr-code { margin: 20px 0; }" +
                        "        .qr-code img { width: 150px; height: 150px; border: 1px solid #ddd; }" +
                        "        .footer { background-color: #ffcc00; color: #ffffff; padding: 10px; text-align: center; font-size: 12px; }" +
                        "        .button { background-color: #ffcc00; color: #ffffff; padding: 10px 20px; border-radius: 5px; text-decoration: none; font-weight: bold; }" +
                        "        .balloons { margin-top: 10px; }" +
                        "        .balloons img { width: 50px; height: auto; margin: 0 5px; }" +
                        "    </style>" +
                        "</head>" +
                        "<body>" +
                        "    <div class='email-container'>" +
                        "        <div class='header'>" +
                        "            <h1>Feliz Aniversário!</h1>" +
                        "            <div class='balloons'>" +
                        "                <img src='https://example.com/balloon1.png' alt='Balão'>" +
                        "                <img src='https://example.com/balloon2.png' alt='Balão'>" +
                        "                <img src='https://example.com/balloon3.png' alt='Balão'>" +
                        "            </div>" +
                        "        </div>" +
                        "        <div class='body'>" +
                        "            <h2>Olá,</h2>" +
                        "           <p>Estamos muito felizes em comemorar esse dia especial com você! Aqui está um presente especial para você.</p>" +
                        "            <div class='qr-code'>" +
                        "                <img src='%s' alt='QR Code'>" +
                        "            </div>" +
                        "            <p>Use o QR Code acima para acessar o seu presente. Aproveite seu dia ao máximo!</p>" +
                        "        </div>" +
                        "        <div class='footer'>" +
                        "            <p>&copy; 2024 Invitemee. Comemore com a gente. Todos os direitos reservados.</p>" +
                        "        </div>" +
                        "    </div>" +
                        "</body>" +
                        "</html>",
                qrCodeUrl);

    }
    public static String getMarriageContent(String qrCodeUrl) {
        return String.format(
                "<!DOCTYPE html>" +
                        "<html lang='en'>" +
                        "<head>" +
                        "    <meta charset='UTF-8'>" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                        "    <style>" +
                        "        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }" +
                        "        .email-container { background-color: #ffffff; width: 100%%; max-width: 600px; margin: 20px auto; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); overflow: hidden; }" +
                        "        .header { background-color: #d4a373; color: #ffffff; padding: 20px; text-align: center; }" +
                        "        .header h1 { margin: 0; font-size: 24px; }" +
                        "        .body { padding: 30px; text-align: center; }" +
                        "        .body h2 { color: #333; font-size: 22px; }" +
                        "        .body p { color: #666; line-height: 1.6; }" +
                        "        .qr-code { margin: 20px 0; }" +
                        "        .qr-code img { width: 150px; height: 150px; border: 1px solid #ddd; }" +
                        "        .footer { background-color: #d4a373; color: #ffffff; padding: 10px; text-align: center; font-size: 12px; }" +
                        "        .button { background-color: #d4a373; color: #ffffff; padding: 10px 20px; border-radius: 5px; text-decoration: none; font-weight: bold; }" +
                        "        .flower { margin-top: 10px; }" +
                        "        .flower img { width: 50px; height: auto; margin: 0 5px; }" +
                        "    </style>" +
                        "</head>" +
                        "<body>" +
                        "    <div class='email-container'>" +
                        "        <div class='header'>" +
                        "            <h1>Comemore o Amor!</h1>" +
                        "            <div class='flower'>" +
                        "                <img src='https://example.com/flower1.png' alt='Flor'>" +
                        "                <img src='https://example.com/flower2.png' alt='Flor'>" +
                        "                <img src='https://example.com/flower3.png' alt='Flor'>" +
                        "            </div>" +
                        "        </div>" +
                        "        <div class='body'>" +
                        "            <h2>Estamos Felizes por Compartilhar Este Momento</h2>" +
                        "           <p>Agradecemos por fazer parte do nosso dia especial. Para acessar todos os detalhes do nosso casamento, utilize o QR Code abaixo.</p>" +
                        "            <div class='qr-code'>" +
                        "                <img src='%s' alt='QR Code'>" +
                        "            </div>" +
                        "            <p>Esperamos vê-lo(a) em nossa celebração. Obrigado por estar ao nosso lado nesta jornada de amor e união.</p>" +
                        "        </div>" +
                        "        <div class='footer'>" +
                        "            <p>&copy; 2024 Nosso Casamento. Todos os direitos reservados.</p>" +
                        "        </div>" +
                        "    </div>" +
                        "</body>" +
                        "</html>",
                qrCodeUrl);

    }
}
