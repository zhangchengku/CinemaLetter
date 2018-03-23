package com.myp.cinema.util;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/**
 * 软键盘工具类
 * @author login
 * @date 2014-9-18
 */

public class SoftInputUtils {

	   /*
	    * 关闭软键盘
	    */
	public static void closeSoftInput(Activity activity) {
			
			if (activity.getCurrentFocus() != null&&activity.getCurrentFocus().getWindowToken() != null) {
				
				((InputMethodManager) activity
						.getSystemService(Context.INPUT_METHOD_SERVICE))
						.hideSoftInputFromWindow(activity.getCurrentFocus()
								.getWindowToken(),
								InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
	   /*
	    * 关闭软键盘
	    */
	public static void closeSoftInput(EditText editText,Activity activity) {
			
			if (activity.getCurrentFocus() != null&&activity.getCurrentFocus().getWindowToken() != null) {
			//	editText.setCursorVisible(false);
				((InputMethodManager) activity
						.getSystemService(Context.INPUT_METHOD_SERVICE))
						.hideSoftInputFromWindow(activity.getCurrentFocus()
								.getWindowToken(),
								InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
		   /*
	     * 打开软键盘
	     */
		public static void openSoftInputs(EditText editText,Activity activity) {

			 editText.setFocusable(true);
	        editText.setFocusableInTouchMode(true);
	        editText.requestFocus();
	  
//	        	String str ="回复"+hint+":";
//	        editText.setText(str);
//	        editText.setSelection(str.length());

	        InputMethodManager inputManager =
	                (InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//	            inputManager.showSoftInput(editText, 0);
	            
	            inputManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	        }
	    /*
	     * 打开软键盘
	     */
		public static void openSoftInput(EditText editText,Activity activity,String hint) {
//			InputMethodManager inputMethodManager = (InputMethodManager) activity
//					.getSystemService(Activity.INPUT_METHOD_SERVICE);
//			if (inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0)) {
//				// 软键盘已弹出
//			} else {
//				// 软键盘未弹出
//			}
//			InputMethodManager inputMethodManager = (InputMethodManager) activity
//					.getSystemService(Context.INPUT_METHOD_SERVICE);
//			inputMethodManager.toggleSoftInput(0,
//					InputMethodManager.HIDE_NOT_ALWAYS);
			 editText.setFocusable(true);
	        editText.setFocusableInTouchMode(true);
	        editText.requestFocus();
	        editText.setCursorVisible(true);
	        if(hint!=null&&!hint.equals("")){
	        	String str ="回复"+hint;
	        editText.setHint(str);
	     
	        }
	InputMethodManager inputManager =
	                    (InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
	                inputManager.showSoftInput(editText, 0);
		}

	
}
