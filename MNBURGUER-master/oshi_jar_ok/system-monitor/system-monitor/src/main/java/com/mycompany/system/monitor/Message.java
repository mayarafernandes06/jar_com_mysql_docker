

package com.mycompany.system.monitor;

import lombok.*;
  
  import java.io.Serializable;

  @AllArgsConstructor
  @Builder(builderClassName = "Builder")
  @Getter
  @Setter
  @NoArgsConstructor
public class Message implements Serializable {
 
    private String text;
    
}