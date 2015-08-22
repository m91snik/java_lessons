package Client;

import java.io.Serializable;

/**
 * Created by Ангелина on 22.08.2015.
 */
public class ClientID implements Serializable{
    private static final long serialVersionUID = 19L;
    private String ip;
    private String port;
    private String nick;

    public ClientID() {}

    public ClientID(String ip, String port, String nick) {
        this.ip = ip;
        this.port = port;
        this.nick = nick;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getNick() {
        return nick;
    }

    @Override
    public String toString() {
        return "ClientID{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientID)) return false;

        ClientID clientID = (ClientID) o;

        if (getIp() != null ? !getIp().equals(clientID.getIp()) : clientID.getIp() != null) return false;
        if (getPort() != null ? !getPort().equals(clientID.getPort()) : clientID.getPort() != null) return false;
        return !(getNick() != null ? !getNick().equals(clientID.getNick()) : clientID.getNick() != null);

    }

    @Override
    public int hashCode() {
        int result = getIp() != null ? getIp().hashCode() : 0;
        result = 31 * result + (getPort() != null ? getPort().hashCode() : 0);
        result = 31 * result + (getNick() != null ? getNick().hashCode() : 0);
        return result;
    }
}
