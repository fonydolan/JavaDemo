package com.dolan.spring.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class QuestExistCondition  implements Condition{

	@Override
	public boolean matches(ConditionContext context,
			AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		Environment env = context.getEnvironment();
		return env.containsProperty("quest");
	}

}
