
package util;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

public class DialogUtil{
	private static ProgressDialog mProgressDialog;
	// ����һ����ʾ��Ϣ�ĶԻ���
	public static void showDialog(final Context ctx, String msg , boolean closeSelf){
		// ����һ��AlertDialog.Builder����
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx).setMessage(msg).setCancelable(false);
		if(closeSelf)
		{
			builder.setPositiveButton("ȷ��", new OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					// ������ǰActivity
					((Activity)ctx).finish();
				}
			});		
		}
		else
		{
			builder.setPositiveButton("ȷ��", null);
		}
		builder.create().show();
	}	
	// ����һ����ʾָ������ĶԻ���
	public static void showDialog(Context ctx , View view)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx).setView(view).setCancelable(false)
		.setPositiveButton("ȷ��", null);
		builder.create().show();
	}
	
	public static final void showResultDialog(Context context, String msg,
			String title) {
		if(msg == null) return;
		String rmsg = msg.replace(",", "\n");
		Log.d("Util", rmsg);
		new AlertDialog.Builder(context).setTitle(title).setMessage(rmsg)
				.setNegativeButton("֪��?", null).create().show();
	}

	public static final void showProgressDialog(Context context, String title,
			String message) {
		dismissDialog();
		if (TextUtils.isEmpty(title)) {
			title = "���Ժ�";
		}
		if (TextUtils.isEmpty(message)) {
			message = "���ڼ���...";
		}
		mProgressDialog = ProgressDialog.show(context, title, message);
	}
	
	public static AlertDialog showConfirmCancelDialog(Context context,
			String title, String message,
			DialogInterface.OnClickListener posListener) {
		AlertDialog dlg = new AlertDialog.Builder(context).setMessage(message)
				.setPositiveButton("ȷ��", posListener)
				.setNegativeButton("ȡ��", null).create();
		dlg.setCanceledOnTouchOutside(false);
		dlg.show();
		return dlg;
	}

	public static final void dismissDialog() {
		if (mProgressDialog != null) {
			mProgressDialog.dismiss();
			mProgressDialog = null;
		}
	}
}
