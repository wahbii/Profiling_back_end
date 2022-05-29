package com.app.tagging.profiling.utils.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MessageExeption {
    private String message;
    private String url;
    private Date date;
}