package model;

import enums.AuctionType;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ITEM_NAME", nullable = false)
    private String itemName;

    private Integer quantity;

    @CreationTimestamp
    private Timestamp createdOn;

    @Column(name = "IMPERIALWEIGHT")
    @ColumnTransformer(
            read = "IMPERIALWEIGHT / 2.20462",
            write = "? * 2.20462"
    )
    private double metricWeight;

    @Enumerated(EnumType.STRING)
    protected AuctionType auctionType;


    private MonetaryAmount initialPrice;

    @AttributeOverrides({
            @AttributeOverride(name = "currencyUnit", column = @Column(name = "Force_Buy_Currency_Unit")),
            @AttributeOverride(name = "price", column = @Column(name = "Force_Buy_Price"))
    })
    private MonetaryAmount forceBuyPrice;

    @NotNull
    private LocalDateTime auctionStart;

    private LocalDateTime auctionEnd;

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public double getMetricWeight() {
        return metricWeight;
    }

    public void setMetricWeight(double metricWeight) {
        this.metricWeight = metricWeight;
    }

    public AuctionType getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(AuctionType auctionType) {
        this.auctionType = auctionType;
    }

    public LocalDateTime getAuctionStart() {
        return auctionStart;
    }

    public void setAuctionStart(LocalDateTime auctionStart) {
        this.auctionStart = auctionStart;
    }

    public LocalDateTime getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(LocalDateTime auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public MonetaryAmount getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(MonetaryAmount initialPrice) {
        this.initialPrice = initialPrice;
    }

    public MonetaryAmount getForceBuyPrice() {
        return forceBuyPrice;
    }

    public void setForceBuyPrice(MonetaryAmount forceBuyPrice) {
        this.forceBuyPrice = forceBuyPrice;
    }
}
