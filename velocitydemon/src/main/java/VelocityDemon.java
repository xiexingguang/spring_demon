import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.ToolManager;

/**
 * Created by 沾雨 on 2017/7/6 下午10:01
 */
public class VelocityDemon {

    private static ToolManager manager = null;

    static {
        Velocity.init();
        Velocity.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_CACHE, false);
        Velocity.setProperty(VelocityEngine.VM_PERM_INLINE_LOCAL, true);
        Velocity.setProperty(VelocityEngine.VM_LIBRARY_AUTORELOAD, false);

        manager = new ToolManager();
        //manager.configure("/engine-sql-velocity-tools.xml");
    }

    public static void main(String[] args) {

        String template ="#set($_group_id = $indParam_ids.get(1))\n"
            + "#set($_cate_id = $indParam_id)\n"
            + "\n"
            + "##设置cate_flag的标志\n"
            + "#if($indParam_level == '1')\n"
            + "    #set($_cate_flag = '-1')\n"
            + "    #set($_group_id='-')\n"
            + "#elseif($indParam_level == '2')\n"
            + "    #set($_cate_flag = '1')\n"
            + "#elseif($indParam_level == '3')\n"
            + "    #set($_cate_flag = '2')\n"
            + "#elseif($indParam_level == '4')\n"
            + "    #set($_cate_flag = '0')\n"
            + "#end\n"
            + "\n"
            + "##flow_flag的数据,给tree.parentId的赋值\n"
            + "#if($tree.level == '1')\n"
            + "    #set($_flow_flag = '2')\n"
            + "#elseif($tree.level == '2')\n"
            + "    #set($_flow_flag = '3')\n"
            + "#elseif($tree.level == '3')\n"
            + "    #set($_flow_flag = '4')\n"
            + "#elseif($tree.level == '4')\n"
            + "    #set($_flow_flag ='5')\n"
            + "#end\n"
            + "\n"
            + "\n"
            + "#define($flow_condition_total)\n"
            + "where\n"
            + "stat_date='$statDate'\n"
            + "and is_cut_c0='Y'\n"
            + "and bc_type='c'\n"
            + "and bu_id='taobao'\n"
            + "##类目的判断的条件\n"
            + "and cate_flag='$_cate_flag'\n"
            + "and cate_id='$_cate_id'\n"
            + "and group_id='$_group_id'\n"
            + "##通道的判断条件\n"
            + "and flow_type='prd'\n"
            + "and flow_flag in ('1','2','3','4')\n"
            + "    #if($tree)\n"
            + "    and flow_flag='$_flow_flag'\n"
            + "    and parent_flow_name='$tree.parentId'\n"
            + "    #else\n"
            + "    #end\n"
            + "#end\n"
            + "\n"
            + "\n"
            + "#define($flow_dim)\n"
            + "stat_date as stat_date\n"
            + ",flow_name as flow_id\n"
            + ",flow_name as flow_name\n"
            + "    #if($tree)\n"
            + "    ,parent_flow_name as parent_flow_id\n"
            + "    ,$tree.level as flow_level\n"
            + "    #else\n"
            + "    ,'-1' as parent_flow_id\n"
            + "    ,'0' as flow_level\n"
            + "    #end\n"
            + ",case when flow_type='4' then 'Y' else 'N' end as is_flow_leaf\n"
            + "#end\n"
            + "\n"
            + "select\n"
            + "flow_name as flow_name\n"
            + ",flow_name as flow_id\n"
            + ",parent_flow_id as parent_flow_id\n"
            + ",is_flow_leaf as is_flow_leaf\n"
            + ",flow_level as flow_level\n"
            + ",$selected_indicators_as\n"
            + "from\n"
            + "(\n"
            + "select\n"
            + "$flow_dim\n"
            + ",ipv_1d_081\n"
            + ",ipv_uv_1d_214\n"
            + ",pay_ord_amt_1d_037\n"
            + ",pay_ord_byr_cnt_1d_036\n"
            + ",pay_ord_cnt_1d_036\n"
            + ",pay_ord_itm_qty_1d_006\n"
            + ",pay_ord_pbt_1d_011\n"
            + ",pay_ord_pot_1d_015\n"
            + ",vst_pay_byr_rate_1d_002\n"
            + ",pay_ord_pit_1d_018\n"
            + ",vst_itm_cnt_1d_006\n"
            + "\n"
            + ",case when hy_ipv_1d_081>0 then ipv_1d_081/hy_ipv_1d_081 else cast(null as double) end as "
            + "hy_ipv_1d_081_rate\n"
            + ",case when hy_ipv_uv_1d_214>0 then ipv_uv_1d_214/hy_ipv_uv_1d_214 else cast(null as double) end as "
            + "hy_ipv_uv_1d_214_rate\n"
            + ",case when hy_pay_ord_amt_1d_037>0 then pay_ord_amt_1d_037/hy_pay_ord_amt_1d_037 else cast(null as "
            + "double) end as hy_pay_ord_amt_1d_037_rate\n"
            + ",case when hy_pay_ord_byr_cnt_1d_036>0 then pay_ord_byr_cnt_1d_036/hy_pay_ord_byr_cnt_1d_036 else cast"
            + "(null as double) end as hy_pay_ord_byr_cnt_1d_036_rate\n"
            + ",pay_ord_pit_1d_018-td_pay_ord_pit_1d_018 as td_pay_ord_pit_1d_018_diff\n"
            + ",case when td_vst_itm_cnt_1d_006>0 then vst_itm_cnt_1d_006/td_vst_itm_cnt_1d_006 else cast(null as "
            + "double) end  as td_vst_itm_cnt_1d_006_rate\n"
            + "from tb_360a_show_stapp_flow_cate_lead_di\n"
            + "$flow_condition_total\n"
            + ") a";

        List list = new ArrayList();
        list.add("-");
        list.add(50010728);
        list.add(124522008);

        ToolContext toolContext = new ToolContext();
        toolContext.put("statDate", "20170705");
        //toolContext.put("indParam_level", 1);
        toolContext.put("indParam_ids", list);
        toolContext.put("selected_indicators_as", "ipv_uv_1d_214");
        toolContext.put("indParam_id", 9);
        StringWriter writer = new StringWriter();
        Velocity.evaluate(toolContext, writer, template, template);

        System.out.println(writer.toString());

    }

}
