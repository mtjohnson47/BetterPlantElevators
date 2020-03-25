package net.mikemk.ramoja.bpelevators.common;

import org.apache.logging.log4j.Level;

import net.mikemk.ramoja.bpelevators.BPElevators;
import net.minecraftforge.common.config.Configuration;

public class Config {

	private static final String CATEGORY_PLANTS = "plants";

	public static boolean isLadderVineEnabled = true;
	public static int ladderVineMaxLength = 12;
	public static boolean isElevatorStalkEnabled = true;
	public static int elevatorStalkMaxLength = 40;
	public static boolean isShulkerRoseEnabled = true;
	public static int shulkerRoseTime = 300;

	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initPlantsConfig(cfg);
		} catch (Exception e1) {
			BPElevators.logger.log(Level.ERROR, "Problem loading config file!", e1);
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}

	private static void initPlantsConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_PLANTS, "Plant configuration");
		// cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.
		isLadderVineEnabled = cfg.getBoolean("LadderVineEnabled", CATEGORY_PLANTS, isLadderVineEnabled, "Is the Ladder Vine Enabled?");
		isElevatorStalkEnabled = cfg.getBoolean("ElevatorStalkEnabled", CATEGORY_PLANTS, isElevatorStalkEnabled, "Is the Elevator Stalk Enabled?");
		isShulkerRoseEnabled = cfg.getBoolean("ShulkerRoseEnabled", CATEGORY_PLANTS, isShulkerRoseEnabled, "Is the Shulker Rose Enabled?");
		ladderVineMaxLength = cfg.getInt("LadderVineMaxLength", CATEGORY_PLANTS, ladderVineMaxLength, 1, 256, "How high above the last support block can ladder vines grow?");
		elevatorStalkMaxLength = cfg.getInt("ElevatorStalkMaxLength", CATEGORY_PLANTS, elevatorStalkMaxLength, 2, 255, "How tall can elevator stalks grow?");
		shulkerRoseTime = cfg.getInt("ShullkerRoseTime", CATEGORY_PLANTS, shulkerRoseTime, 1, Integer.MAX_VALUE, "How long, in ticks, should the levitation effect of the shulker rose last?");
	}
}
