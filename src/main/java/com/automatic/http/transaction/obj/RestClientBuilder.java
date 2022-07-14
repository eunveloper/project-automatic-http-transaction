package com.automatic.http.transaction.obj;

public class RestClientBuilder {

    private int connectionRequestTimeout;
    private int connectionTimeout;
    private int socketTimeout;
    private int maxConnectionTotal;

    public static RestClient create(BuilderType type) {
        RestClient restClient = new RestClient();

        int connectionRequestTimeout;
        int connectionTimeout;
        int socketTimeout;
        int maxConnectionTotal;

        switch (type) {
            case MINIMUM:
                connectionRequestTimeout = 5000;
                connectionTimeout = 3000;
                socketTimeout = 5000;
                maxConnectionTotal = 50;
                break;
            case MAXIMUM:
                connectionRequestTimeout = 30000;
                connectionTimeout = 10000;
                socketTimeout = 30000;
                maxConnectionTotal = 150;
                break;
            case DEFAULT:
            default:
                connectionRequestTimeout = 10000;
                connectionTimeout = 5000;
                socketTimeout = 10000;
                maxConnectionTotal = 100;
                break;
        }

        restClient.setConnectionRequestTimeout(connectionRequestTimeout);
        restClient.setConnectionTimeout(connectionTimeout);
        restClient.setSocketTimeout(socketTimeout);
        restClient.setMaxConnectionTotal(maxConnectionTotal);
        restClient.init();

        return restClient;
    }

    public static RestClientBuilder custom() {
        return new RestClientBuilder();
    }

    public RestClient create() {
        RestClient restClient = new RestClient();
        restClient.setConnectionRequestTimeout(this.connectionRequestTimeout);
        restClient.setConnectionTimeout(this.connectionTimeout);
        restClient.setSocketTimeout(this.socketTimeout);
        restClient.setMaxConnectionTotal(this.maxConnectionTotal);
        restClient.init();
        return restClient;
    }

    public RestClientBuilder setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
        return this;
    }

    public RestClientBuilder setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    public RestClientBuilder setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
        return this;
    }

    public RestClientBuilder setMaxConnectionTotal(int maxConnectionTotal) {
        this.maxConnectionTotal = maxConnectionTotal;
        return this;
    }

}
