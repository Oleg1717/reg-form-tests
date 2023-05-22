package helpers.junit;

import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;
import config.ConfigHelper;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;

public class CustomStrategy implements ParallelExecutionConfiguration, ParallelExecutionConfigurationStrategy {

    @Override
    public Predicate<? super ForkJoinPool> getSaturatePredicate() {
        return (ForkJoinPool p) -> true;
    }

    private static final int PARALLEL_TESTS_COUNT = ConfigHelper.projectConfig().threads();

    @Override
    public int getParallelism() {
        return PARALLEL_TESTS_COUNT;
    }

    @Override
    public int getMinimumRunnable() {
        return PARALLEL_TESTS_COUNT;
    }

    @Override
    public int getMaxPoolSize() {
        return PARALLEL_TESTS_COUNT;
    }

    @Override
    public int getCorePoolSize() {
        return PARALLEL_TESTS_COUNT;
    }

    @Override
    public int getKeepAliveSeconds() {
        return 90;
    }

    @Override
    public ParallelExecutionConfiguration createConfiguration(final ConfigurationParameters configurationParameters) {
        return this;
    }

}
