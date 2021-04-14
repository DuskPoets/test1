package com.zqy.pojo;

import javax.persistence.*;

@Table(name = "apply_state")
public class ApplyState {
    @Id
    @Column(name = "apply_state_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applyStateId;

    private String name;

    /**
     * @return apply_state_id
     */
    public Integer getApplyStateId() {
        return applyStateId;
    }

    /**
     * @param applyStateId
     */
    public void setApplyStateId(Integer applyStateId) {
        this.applyStateId = applyStateId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
