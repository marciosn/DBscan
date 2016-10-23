package br.com.ufc.quixada.dbscan.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	public static void main(String [] args) {
		String mo = "natalia.lionelm@gmail.com ";

		  String from = "devmobilebr6@gmail.com";
	      String pass = "!@#mob.dev006##@!";
	      String to = "marciosouzanobre@gmail.com";
	      String port = "587";
	      String host = "smtp.gmail.com";

	      Properties properties = System.getProperties();
	      properties.put("mail.smtp.host", host);
	      properties.put("mail.smtp.user", from);
	      properties.put("mail.smtp.password", pass);
	      properties.put("mail.smtp.port", port);
	      properties.put("mail.smtp.starttls.enable","true");
	      properties.put("mail.smtps.ssl.enable", "true");
	      properties.put("mail.smtp.auth", "true");

	      Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	              return new PasswordAuthentication(from, pass);
	          }
	      });

	      try {
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(mo));
	         message.setSubject("This is the Subject Line!");
	         message.setContent(getTemplateMail(), "text/html");
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	
	public static String getTemplateMail(){
		return  "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"ISO-8859-1\">"
				+ "<title>"+ "TEMPLATE GMAIL" +"</title>"
						+ "<style>"
						+ ".datagrid table {border-collapse: collapse;text-align: left;width: 100%;}"
						+ ".datagrid {font: normal 12px/150% Arial, Helvetica, sans-serif;background: #fff;overflow: hidden;border: 1px solid #652299;-webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;}"
						+ ".datagrid table td, .datagrid table th {padding: 3px 10px;}"
						+ ".datagrid table thead th {background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #652299), color-stop(1, #4D1A75));background: -moz-linear-gradient(center top, #652299 5%, #4D1A75 100%);filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#652299',endColorstr='#4D1A75');background-color: #652299;color: #FFFFFF;font-size: 15px;font-weight: bold;border-left: 1px solid #714399;}"
						+ ".datagrid table thead th:first-child {border: none;}"
						+ ".datagrid table tbody td {color: #4D1A75;border-left: 1px solid #E7BDFF;font-size: 12px;font-weight: normal;}"
						+ ".datagrid table tbody .alt td {background: #F4E3FF;color: #4D1A75;}"
						+ ".datagrid table tbody td:first-child {border-left: none;}"
						+ ".datagrid table tbody tr:last-child td {border-bottom: none;}"
						+ ".datagrid table tfoot td div {border-top: 1px solid #652299;background: #F4E3FF;}"
						+ ".datagrid table tfoot td {padding: 0;font-size: 12px}"
						+ ".datagrid table tfoot td div {padding: 2px;}"
						+ ".datagrid table tfoot td ul {margin: 0;padding: 0;list-style: none;text-align: right;}"
						+ ".datagrid table tfoot  li {display: inline;}"
						+ ".datagrid table tfoot li a {text-decoration: none;display: inline-block;padding: 2px 8px;margin: 1px;color: #FFFFFF;border: 1px solid #652299;-webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #652299), color-stop(1, #4D1A75));background: -moz-linear-gradient(center top, #652299 5%, #4D1A75 100%);filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#652299',endColorstr='#4D1A75');background-color: #652299;}"
						+ ".datagrid table tfoot ul.active, .datagrid table tfoot ul a:hover {text-decoration: none;border-color: #4D1A75;color: #FFFFFF;background: none;background-color: #652299;}"
						+ "div.dhtmlx_window_active, div.dhx_modal_cover_dv {position: fixed !important;}"
						+ "</style>"
						+ "</head>"
						+ "<body>"
						+ "<div class=\"datagrid\">"
								+ "<table>"
									+ "<thead>"
										+ "<tr>"
											+ "<th>"+ "Coluna 1" + "</th>"
											+ "<th>"+ "Coluna 2" + "</th>"
											+ "<th>"+ "Coluna 3" + "</th>"
											+ "<th>"+ "Coluna 4" + "</th>"
										+ "</tr>"
									+ "</thead>"
									+ "<tbody>"
										+ "<tr>"
											+ "<td>data 1</td>"
											+ "<td>data 2</td>"
											+ "<td>data 3</td>"
											+ "<td>data 4</td>"
										+ "</tr>"
										+ "<tr class=\"alt\">"
											+ "<td>data 11</td>"
											+ "<td>data 22</td>"
											+ "<td>data 33</td>"
											+ "<td>data 44</td>"
										+ "</tr>"
											+ "<tr>"
											+ "<td>data 111</td>"
											+ "<td>data 222</td>"
											+ "<td>data 333</td>"
											+ "<td>data 444</td>"
										+ "</tr>"
											+ "<tr class=\"alt\">"
											+ "<td>data 1111</td>"
											+ "<td>data 2222</td>"
											+ "<td>data 3333</td>"
											+ "<td>data 4444</td>"
										+ "</tr>"
										+ "<tr>"
											+ "<td>data 11111</td>"
											+ "<td>data 22222</td>"
											+ "<td>data 33333</td>"
											+ "<td>data 44444</td>"
										+ "</tr>"
									+ "</tbody>"
								+ "</table>"
							+ "</div>"
						+ "</body>"
						+ "</html>";
	}
}
