package ch.makery.address.model;

import javafx.beans.property.*;


public class Movie {

    private  StringProperty title;
    private  StringProperty time;
    private  StringProperty director;
    private  StringProperty releaseDate;
    private  DoubleProperty ticketPrice;
    private  StringProperty producer;



    public Movie(StringProperty title, StringProperty director, StringProperty releaseDate, DoubleProperty ticketPrice, StringProperty time, StringProperty producer) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.ticketPrice = ticketPrice;
        this.time = time;
        this.producer = producer;
    }


    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getDirector() {
        return director.get();
    }

    public StringProperty directorProperty() {
        return director;
    }

    public void setDirector(String director) {
        this.director.set(director);
    }

    public String getReleaseDate() {
        return releaseDate.get();
    }

    public StringProperty releaseDateProperty() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate.set(releaseDate);
    }

    public double getTicketPrice() {
        return ticketPrice.get();
    }

    public DoubleProperty ticketPriceProperty() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice.set(ticketPrice);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice.set(ticketPrice);
    }

    public String getProducer() {
        return producer.get();
    }

    public StringProperty producerProperty() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer.set(producer);
    }
}