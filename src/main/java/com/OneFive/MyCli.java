package com.OneFive;

import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MyCli {
    private final Options options;
    private final CommandLineParser parser;
    private CommandLine line;
    private final Map<String, Consumer<Object[]>> functionMap;

    private MyCli() {
        options = new Options();
        parser = new DefaultParser();
        functionMap = new HashMap<>();
        line = null;
    }

    private static final MyCli instance = new MyCli();

    public static MyCli getInstance() {
        return instance;
    }

    public void addOption(Option option, Consumer<Object[]> callback) {
        options.addOption(option);
        functionMap.put(option.getOpt(), callback);
    }

    public void parseAllOptions(String[] args) throws ParseException {
        line = getCommandLine(args);
        functionMap.forEach((opt, callback) -> {
            if (line.hasOption(opt)) {
                String[] values = line.getOptionValues(opt);
                callback.accept(values);
            }
        });
    }

    public CommandLine getCommandLine(String[] args) throws ParseException {
        return parser.parse(options, args);
    }

    public Options getOptions() {
        return options;
    }
}
