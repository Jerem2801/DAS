package com.example.jlx.das.entry.character;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jlx.das.data.DataPoolManager;
import com.example.jlx.das.data.DataPoolReader;
import com.example.jlx.das.entry.ValueUtils;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.entry.rule.ItemRuleReader;
import com.example.jlx.das.stream.AssetUtils;
import com.google.android.flexbox.FlexboxLayout;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CharacterReader {

    private static final String RULE_PATH = "_rule" + DataPoolReader.CSV;

    private CharacterReader(){

    }

    public static Character getCharacter(Context context, String fragmentId){
        Map<ItemRule,String> ruleAndValue = Maps.newHashMap();
        String root = fragmentId + "/" + fragmentId;

        String pathRule =  root + RULE_PATH;
        List<String> datas = AssetUtils.getData(context, pathRule);
        Map<String,ItemRule> itemsRuleWithId = ItemRuleReader.getItemsRuleWithId(datas);

        String pathValue = fragmentId + DataPoolReader.CSV;
        Map<String, String> values = ValueUtils.getValues(context, pathValue);
        for(Map.Entry<String, ItemRule> entry : itemsRuleWithId.entrySet()){
            String key = entry.getKey();
            ItemRule itemRule = entry.getValue();

            String value = values.get(key);
            if(StringUtils.isBlank(value)){
                value = ValueUtils.EMPTY;
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

        return new Character(sortMap);
    }

    public static Character getCharacterNewValue(LinearLayout linearMother, Map<ItemRule,Integer> valueViewId){
        Map<ItemRule,String> ruleAndValue = Maps.newHashMap();

        for(Map.Entry<ItemRule,Integer> entry : valueViewId.entrySet()){
            ItemRule itemRule = entry.getKey();
            Integer key = entry.getValue();

            View viewById = linearMother.findViewById(key);
            String value = StringUtils.EMPTY;

            if(StringUtils.equals(itemRule.getTypeValue(),"custom")){
                EditText text = (EditText) viewById;
                if(text != null){
                    String textValue = text.getText().toString();
                    if(StringUtils.isNotBlank(textValue)){
                        value = textValue;
                    }else{
                        value = ValueUtils.EMPTY;
                    }
                }
            }else if(StringUtils.equals(itemRule.getRule(),"list")){
                List<Item> items = DataPoolManager.getItems(itemRule.getReference());
                FlexboxLayout flexboxLayout = (FlexboxLayout) viewById;
                TextView childAt1 = (TextView) flexboxLayout.getChildAt(0);
                String text = (String) childAt1.getText();
                String[] splits = StringUtils.split(text, ";");
                for(String split : splits){
                    if(StringUtils.isNumeric(split)) {
                        int i = Integer.parseInt(split);
                        if (StringUtils.isBlank(value)) {
                            value = items.get(i).getId();
                        } else {
                            value += "&" + items.get(i).getId();
                        }
                    }
                }
            }else{
                Spinner spinner = (Spinner) viewById;
                Item item = (Item) spinner.getSelectedItem();
                if(item != null){
                    value = item.getId();
                }
            }

            ruleAndValue.put(itemRule,value);

        }

        return new Character(ruleAndValue);
    }
}
