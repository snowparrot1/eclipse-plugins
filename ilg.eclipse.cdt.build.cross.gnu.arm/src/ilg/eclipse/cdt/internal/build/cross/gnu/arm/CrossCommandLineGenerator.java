/*******************************************************************************
 * Copyright (c) 2009, 2012 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Doug Schaefer - initial API and implementation
 *******************************************************************************/
package ilg.eclipse.cdt.internal.build.cross.gnu.arm;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.cdt.managedbuilder.core.BuildException;
import org.eclipse.cdt.managedbuilder.core.IBuildObject;
import org.eclipse.cdt.managedbuilder.core.IManagedCommandLineInfo;
import org.eclipse.cdt.managedbuilder.core.IOption;
import org.eclipse.cdt.managedbuilder.core.IOptionApplicability;
import org.eclipse.cdt.managedbuilder.core.IOptionCategory;
import org.eclipse.cdt.managedbuilder.core.IOptionCategoryApplicability;
import org.eclipse.cdt.managedbuilder.core.IResourceConfiguration;
import org.eclipse.cdt.managedbuilder.core.ITool;
import org.eclipse.cdt.managedbuilder.core.IToolChain;
import org.eclipse.cdt.managedbuilder.internal.core.ManagedCommandLineGenerator;
import org.eclipse.cdt.managedbuilder.internal.core.ResourceConfiguration;

public class CrossCommandLineGenerator extends ManagedCommandLineGenerator {

	@Override
	public IManagedCommandLineInfo generateCommandLineInfo(ITool tool,
			String commandName, String[] flags, String outputFlag,
			String outputPrefix, String outputName, String[] inputResources,
			String commandLinePattern) {
		IBuildObject parent = tool.getParent();
		IToolChain toolchain;
		if (parent instanceof ResourceConfiguration)
			toolchain = ((ResourceConfiguration) parent).getBaseToolChain();
		else
			toolchain = (IToolChain) parent;

		IOption option = toolchain
				.getOptionBySuperClassId(Activator.getOptionPrefix()+"option.cross.gnu.arm.prefix"); //$NON-NLS-1$
		String prefix = (String) option.getValue();
		String newCommandName = prefix + commandName;

		return super.generateCommandLineInfo(tool, newCommandName, flags,
				outputFlag, outputPrefix, outputName, inputResources,
				commandLinePattern);
	}

}