package com.lidiabazhenova.listener;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class CustomRunner extends BlockJUnit4ClassRunner {
    public CustomRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(new JUnitExecutionListener());
        notifier.fireTestRunStarted(getDescription());
        super.run(notifier);
    }
}
