package org.eugens21.luma.web.functional;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface ScrollTo {
}
