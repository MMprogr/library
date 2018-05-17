package pl.mmprogr.library.validator;

import org.springframework.stereotype.Component;

@Component
public class BookValidator {
	public boolean isNumberInText(String text){
		return text.chars().allMatch( Character::isDigit );
	}
}
