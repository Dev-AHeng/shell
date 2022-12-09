package aheng.shell.base;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 解析MY_AOD的json
 */
public class AODStyleData implements Cloneable, Serializable {
    public int aodStyle;
    public int aodType;
    public int bold;
    public int[] color;
    public int colorIndex;
    public int composing;
    public int fontSize;
    public int index;
    public int isShowBattery;
    public int isShowCalendar;
    public int isShowFootstep;
    public int isShowLunarCalendar;
    public int isShowNotification;
    public int isShowRaiseTime;
    public int isShowTime;
    public int isShowWeather;
    public String personalImage;
    public String personalSignature;
    public int subStyle;
    public String typeString;
    public String zkPathString;
    
    public AODStyleData() {
    }
    
    public AODStyleData(Builder builder) {
        this.aodType = builder.aodType;
        this.aodStyle = builder.aodStyle;
        this.index = builder.index;
        this.zkPathString = builder.zkPathString;
        this.color = builder.color;
        this.colorIndex = builder.colorIndex;
        this.composing = builder.composing;
        this.bold = builder.bold;
        this.fontSize = builder.fontSize;
        this.personalSignature = builder.personalSignature;
        this.isShowTime = builder.isShowTime;
        this.isShowCalendar = builder.isShowCalendar;
        this.isShowLunarCalendar = builder.isShowLunarCalendar;
        this.isShowBattery = builder.isShowBattery;
        this.isShowFootstep = builder.isShowFootstep;
        this.isShowWeather = builder.isShowWeather;
        this.isShowRaiseTime = builder.isShowRaiseTime;
        this.isShowNotification = builder.isShowNotification;
        this.subStyle = builder.subStyle;
        this.personalImage = builder.personalImage;
    }
    
    public int getAodStyle() {
        return this.aodStyle;
    }
    
    public void setAodStyle(int i2) {
        this.aodStyle = i2;
    }
    
    public int getAodType() {
        return this.aodType;
    }
    
    public void setAodType(int i2) {
        this.aodType = i2;
    }
    
    public int getBold() {
        return this.bold;
    }
    
    public void setBold(int i2) {
        this.bold = i2;
    }
    
    public int[] getColor() {
        return this.color;
    }
    
    public void setColor(int[] iArr) {
        this.color = iArr;
    }
    
    public int getColorIndex() {
        return this.colorIndex;
    }
    
    public void setColorIndex(int i2) {
        this.colorIndex = i2;
    }
    
    public int getComposing() {
        return this.composing;
    }
    
    public void setComposing(int i2) {
        this.composing = i2;
    }
    
    public int getFontSize() {
        return this.fontSize;
    }
    
    public void setFontSize(int i2) {
        this.fontSize = i2;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(int i2) {
        this.index = i2;
    }
    
    public int getIsShowBattery() {
        return this.isShowBattery;
    }
    
    public void setIsShowBattery(int i2) {
        this.isShowBattery = i2;
    }
    
    public int getIsShowCalendar() {
        return this.isShowCalendar;
    }
    
    public void setIsShowCalendar(int i2) {
        this.isShowCalendar = i2;
    }
    
    public int getIsShowFootstep() {
        return this.isShowFootstep;
    }
    
    public void setIsShowFootstep(int i2) {
        this.isShowFootstep = i2;
    }
    
    public int getIsShowLunarCalendar() {
        return this.isShowLunarCalendar;
    }
    
    public void setIsShowLunarCalendar(int i2) {
        this.isShowLunarCalendar = i2;
    }
    
    public int getIsShowNotification() {
        return this.isShowNotification;
    }
    
    public void setIsShowNotification(int i2) {
        this.isShowNotification = i2;
    }
    
    public int getIsShowRaiseTime() {
        return this.isShowRaiseTime;
    }
    
    public void setIsShowRaiseTime(int i2) {
        this.isShowRaiseTime = i2;
    }
    
    public int getIsShowTime() {
        return this.isShowTime;
    }
    
    public void setIsShowTime(int i2) {
        this.isShowTime = i2;
    }
    
    public int getIsShowWeather() {
        return this.isShowWeather;
    }
    
    public void setIsShowWeather(int i2) {
        this.isShowWeather = i2;
    }
    
    public String getPersonalImage() {
        return this.personalImage;
    }
    
    public void setPersonalImage(String str) {
        this.personalImage = str;
    }
    
    public String getPersonalSignature() {
        return this.personalSignature;
    }
    
    public void setPersonalSignature(String str) {
        this.personalSignature = str;
    }
    
    public int getSubStyle() {
        return this.subStyle;
    }
    
    public void setSubStyle(int i2) {
        this.subStyle = i2;
    }
    
    public String getTypeString() {
        return this.typeString;
    }
    
    public void setTypeString(String str) {
        this.typeString = str;
    }
    
    public String getZkPathString() {
        return this.zkPathString;
    }
    
    public void setZkPathString(String str) {
        this.zkPathString = str;
    }
    
    // @Override
    // public String toString() {
    //     return "AODStyleData{aodType=" + this.aodType + ", personalSignature='" + this.personalSignature + "'}";
    // }
    
    
    @Override
    public String toString() {
        return "AODStyleData{" +
                "aodStyle=" + aodStyle +
                ", aodType=" + aodType +
                ", bold=" + bold +
                ", color=" + Arrays.toString(color) +
                ", colorIndex=" + colorIndex +
                ", composing=" + composing +
                ", fontSize=" + fontSize +
                ", index=" + index +
                ", isShowBattery=" + isShowBattery +
                ", isShowCalendar=" + isShowCalendar +
                ", isShowFootstep=" + isShowFootstep +
                ", isShowLunarCalendar=" + isShowLunarCalendar +
                ", isShowNotification=" + isShowNotification +
                ", isShowRaiseTime=" + isShowRaiseTime +
                ", isShowTime=" + isShowTime +
                ", isShowWeather=" + isShowWeather +
                ", personalImage='" + personalImage + '\'' +
                ", personalSignature='" + personalSignature + '\'' +
                ", subStyle=" + subStyle +
                ", typeString='" + typeString + '\'' +
                ", zkPathString='" + zkPathString + '\'' +
                '}';
    }
    
    @Override
    public AODStyleData clone() {
        try {
            return (AODStyleData) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
    
    public static class Builder {
        public int aodStyle;
        public int aodType;
        public int bold;
        public int[] color;
        public int colorIndex;
        public int composing;
        public int fontSize;
        public int index;
        public int isShowBattery;
        public int isShowCalendar;
        public int isShowFootstep;
        public int isShowLunarCalendar;
        public int isShowNotification;
        public int isShowRaiseTime;
        public int isShowTime;
        public int isShowWeather;
        public String personalImage;
        public String personalSignature;
        public int subStyle;
        public String typeString;
        public String zkPathString;
        
        public AODStyleData build() {
            return new AODStyleData(this);
        }
        
        public Builder setAodStyle(int i2) {
            this.aodStyle = i2;
            return this;
        }
        
        public Builder setAodType(int i2) {
            this.aodType = i2;
            return this;
        }
        
        public Builder setBold(int i2) {
            this.bold = i2;
            return this;
        }
        
        public Builder setColor(int[] iArr) {
            this.color = iArr;
            return this;
        }
        
        public Builder setColorIndex(int i2) {
            this.colorIndex = i2;
            return this;
        }
        
        public Builder setComposing(int i2) {
            this.composing = i2;
            return this;
        }
        
        public Builder setFontSize(int i2) {
            this.fontSize = i2;
            return this;
        }
        
        public Builder setIndex(int i2) {
            this.index = i2;
            return this;
        }
        
        public Builder setIsShowBattery(int i2) {
            this.isShowBattery = i2;
            return this;
        }
        
        public Builder setIsShowCalendar(int i2) {
            this.isShowCalendar = i2;
            return this;
        }
        
        public Builder setIsShowFootstep(int i2) {
            this.isShowFootstep = i2;
            return this;
        }
        
        public Builder setIsShowLunarCalendar(int i2) {
            this.isShowLunarCalendar = i2;
            return this;
        }
        
        public Builder setIsShowNotification(int i2) {
            this.isShowNotification = i2;
            return this;
        }
        
        public Builder setIsShowRaiseTime(int i2) {
            this.isShowRaiseTime = i2;
            return this;
        }
        
        public Builder setIsShowTime(int i2) {
            this.isShowTime = i2;
            return this;
        }
        
        public Builder setIsShowWeather(int i2) {
            this.isShowWeather = i2;
            return this;
        }
        
        public Builder setPersonalImage(String str) {
            this.personalImage = str;
            return this;
        }
        
        public Builder setPersonalSignature(String str) {
            this.personalSignature = str;
            return this;
        }
        
        public Builder setSubStyle(int i2) {
            this.subStyle = i2;
            return this;
        }
        
        public Builder setTypeString(String str) {
            this.typeString = str;
            return this;
        }
        
        public Builder setZkPathString(String str) {
            this.zkPathString = str;
            return this;
        }
    }
}