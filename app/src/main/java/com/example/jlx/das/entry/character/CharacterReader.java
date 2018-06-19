package com.example.jlx.das.entry.character;

import android.content.Context;
import android.renderscript.Sampler;

import com.example.jlx.das.entry.ValueUtils;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.entry.rule.ItemRuleReader;
import com.example.jlx.das.stream.AssetUtils;
import com.example.jlx.das.stream.ReaderConstant;
import com.example.jlx.das.stream.RessourceUtils;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CharacterReader {

    private static final String RULE_PATH = "_rule.csv";
    private static final String VALUE_PATH = "_value.csv";

    private static final int ID = 0;
    private static final int VALUE = 1;
    private static final String EMPTY = "empty";

    private CharacterReader(){

    }

    public static CharacterDisplay getCharacter(Context context, String fragmentId){
        Map<ItemRule,String> ruleAndValue = Maps.newHashMap();
        String root = fragmentId + "/"+ fragmentId;

        String pathRule =  root + RULE_PATH;
        List<String> datas = AssetUtils.getData(context, pathRule);
        Map<String,ItemRule> itemsRuleWithId = ItemRuleReader.getItemsRuleWithId(datas);

        String pathValue = fragmentId + ".csv";
        Map<String, String> values = ValueUtils.getValues(context, pathValue);
        for(Map.Entry<String, ItemRule> entry : itemsRuleWithId.entrySet()){
            String key = entry.getKey();
            ItemRule itemRule = entry.getValue();

            String value = values.get(key);
            if(StringUtils.isBlank(value)){
                value = EMPTY;
            }
            ruleAndValue.put(itemRule,value);
        }

        Map<ItemRule, String> sortMap = new TreeMap<ItemRule, String>(
                new Comparator<ItemRule>() {
                    @Override public int compare(ItemRule p1, ItemRule p2) {
                        return p1.getOrder() - p2.getOrder();
                    }
                }
        );
        sortMap.putAll(ruleAndValue);

        return new CharacterDisplay(sortMap);
    }
}
