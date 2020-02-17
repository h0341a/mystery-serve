package com.ccjr.model.dataobject;


import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author mybatis-generator
 */
@Data
public class User implements Serializable {
    private Byte uid;

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}