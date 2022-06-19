package com.lh.kafka.test.entity;


/**
 * The table CARD
 */
public class CardDO {

    /**
     * id ID.
     */
    private Long id;
    /**
     * idCard ID_CARD.
     */
    private String idCard;

    /**
     * Set id ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId() {
        return id;
    }

    /**
     * Set idCard ID_CARD.
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * Get idCard ID_CARD.
     *
     * @return the string
     */
    public String getIdCard() {
        return idCard;
    }
}
