package paho_mqtt_client;

public class principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String topic        = args[0];
        String content      = args[1];
        int qos             = 0;//Integer.getInteger(args[2]);
        String broker       = "tcp://"+args[3]+":"+args[4];
        String clientId     = args[5];
		
		mqtt_client client= new mqtt_client();
		client.run_client(topic,content,qos,broker,clientId);

	}

}
