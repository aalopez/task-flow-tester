package org.emg.adf.tftester.rt.util;

import org.emg.adf.tftester.rt.model.TaskFlow;
import org.emg.adf.tftester.rt.model.TaskFlowTestCase;
import org.emg.adf.tftester.rt.model.ValueObject;


/**
 * Util class for GreenSuite TaskFlow Tester project.
 */
public final class GreenSuiteUtil {
    public GreenSuiteUtil() {
        throw new RuntimeException("Class not available for instantiation.");
    }

    /**
     * Helper method to add default test cases for GreenSuite.
     * @param tf
     */
    public static void addDefaultTestCasesGreenSuite(TaskFlow tf) {
        TaskFlowTestCase desaTC = createGreenSuiteTestCase(tf, "Desa", "Desa params");
        TaskFlowTestCase testTC = createGreenSuiteTestCase(tf, "Test", "Test params");

        ValueObject insertParam = createGreenSuiteParam("insertar", Boolean.class.getName(), String.valueOf(true));
        ValueObject borrarParam = createGreenSuiteParam("borrar", Boolean.class.getName(), String.valueOf(true));
        ValueObject consultaParam = createGreenSuiteParam("consultar", Boolean.class.getName(), String.valueOf(true));
        ValueObject modificarParam = createGreenSuiteParam("modificar", Boolean.class.getName(), String.valueOf(true));
        ValueObject imprimirParam = createGreenSuiteParam("imprimir", Boolean.class.getName(), String.valueOf(true));
        ValueObject ejecutarParam = createGreenSuiteParam("ejecutar", Boolean.class.getName(), String.valueOf(true));
        ValueObject usuarioDesaParam = createGreenSuiteParam("usuario", String.class.getName(), "FPLDEW");
        ValueObject usuarioTestParam = createGreenSuiteParam("usuario", String.class.getName(), "FPLPRW");
        ValueObject formaParam = createGreenSuiteParam("forma", String.class.getName(), null);

        desaTC.getParamValueObjects().add(insertParam);
        desaTC.getParamValueObjects().add(borrarParam);
        desaTC.getParamValueObjects().add(consultaParam);
        desaTC.getParamValueObjects().add(modificarParam);
        desaTC.getParamValueObjects().add(imprimirParam);
        desaTC.getParamValueObjects().add(ejecutarParam);
        desaTC.getParamValueObjects().add(usuarioDesaParam);
        desaTC.getParamValueObjects().add(formaParam);


        testTC.getParamValueObjects().add(insertParam);
        testTC.getParamValueObjects().add(borrarParam);
        testTC.getParamValueObjects().add(consultaParam);
        testTC.getParamValueObjects().add(modificarParam);
        testTC.getParamValueObjects().add(imprimirParam);
        testTC.getParamValueObjects().add(ejecutarParam);
        testTC.getParamValueObjects().add(usuarioTestParam);
        testTC.getParamValueObjects().add(formaParam);
    }

    /**
     * Creates a greensuite testcase for the taskflow passed as param with default values for RunAsCall=false, RunInRegion=true and
     * StretchLayout=true.
     * @param tf
     * @param name
     * @param desc
     * @return New Test Case for the TaskFlow passed as param.
     */
    private static TaskFlowTestCase createGreenSuiteTestCase(TaskFlow tf, String name, String desc) {
        TaskFlowTestCase tc = new TaskFlowTestCase(tf);
        tf.addTestCase(tc);
        tc.setDescription(name);
        tc.setName(desc);
        tc.setRunAscall(false);
        tc.setRunInRegion(true);
        tc.setStretchLayout(true);

        return tc;
    }

    /**
     * Creates params, always with values as Strings, nulls are treated as empty strings.
     * @param paramName
     * @param className
     * @param value
     * @return New ValueObject.
     */
    private static ValueObject createGreenSuiteParam(String paramName, String className, String value) {

        ValueObject vo = new ValueObject(paramName, className, null, false);
        vo.setValueAsString(value != null ? value : "");

        return vo;
    }
}
