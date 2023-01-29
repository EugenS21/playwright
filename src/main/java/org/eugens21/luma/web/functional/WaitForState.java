package org.eugens21.luma.web.functional;

import com.microsoft.playwright.options.WaitForSelectorState;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface WaitForState {

    WaitForSelectorState value() default VISIBLE;

}
