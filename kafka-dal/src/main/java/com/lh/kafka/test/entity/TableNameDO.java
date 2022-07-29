package com.lh.kafka.test.entity;


/**
 * The table TABLE_NAME
 */
public class TableNameDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * name NAME.
     */
    private String name;

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set name NAME.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name NAME.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }
}
