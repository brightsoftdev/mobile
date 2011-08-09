//
//  Authorization.m
//  Nellodee
//
//  Created by Ada Hopper on 24/06/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "Authorization.h"
#import "NellodeeApp.h"

@implementation Authorization

@synthesize responseData,currentCookies;



- (BOOL) formBasedAuth :(NSString*)username :(NSString*) password{
	NSLog(@" --------- formBasedAuth -----------");
	NellodeeApp *sharedNell = [NellodeeApp sharedNellodeeData];
	NSString *formAuthURL =[[sharedNell sakaiURL] stringByAppendingString:@"/system/sling/formlogin"];
	NSLog(@"[FORM BASED AUTH] Sakai url: %@",formAuthURL);
	NSLog(@"\n[FORM BASED AUTH] Username: %@ - Password: %@ ", username, password);
	
	//Formating post data. 
	NSString *post = [NSString 
					   stringWithFormat:@"sakaiauth:un=%@&sakaiauth:pw=%@&sakaiauth:login=1&_charset_=utf-8",username,password];
	NSData *postData = [post dataUsingEncoding:NSASCIIStringEncoding allowLossyConversion:YES];
	NSString *postLength = [NSString stringWithFormat:@"%d", [postData length]];


	//Creating the request
	//NSMutableURLRequest *request = [NSMutableURLRequest 
	//								requestWithURL:[NSURL URLWithString:@"http://10.211.55.2:8080/system/sling/formlogin"]];
	NSMutableURLRequest *request = [NSMutableURLRequest 
									requestWithURL:[NSURL URLWithString:formAuthURL]];
	[request setHTTPMethod:@"POST"];
	[request addValue:[sharedNell sakaiURL] forHTTPHeaderField:@"Referer"];
	[request setValue:postLength forHTTPHeaderField:@"Content-Length"];
	[request setValue:@"application/x-www-form-urlencoded" forHTTPHeaderField:@"Content-Type"];
	[request setHTTPBody:postData];
	[request setHTTPShouldHandleCookies:YES];


	NSURLResponse *response =[[NSURLResponse alloc]init];
	NSError *error = nil;
	
	//Calling the web service
	@try {
		
		NSData * data=[NSURLConnection sendSynchronousRequest:request returningResponse:&response error:&error]; 
		NSMutableString *string = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
		NSLog(@"Response: ", string);
		NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
		NSInteger status = [httpResponse statusCode];
		NSLog(@"Status: %d",status);
		if (status == 200) {
			// Get an array with all the cookies 
			self.currentCookies =[NSHTTPCookie cookiesWithResponseHeaderFields:[httpResponse allHeaderFields]
																		forURL:[NSURL URLWithString:[sharedNell sakaiURL]]];
			// Add the array of cookies in the shared cookie storage instance 
			[[NSHTTPCookieStorage sharedHTTPCookieStorage]
			 setCookies:self.currentCookies
			 forURL:[NSURL URLWithString:[sharedNell sakaiURL]]
			 mainDocumentURL:nil];
			
			for (NSHTTPCookie* cookie in self.currentCookies)
				NSLog(@"\nName: %@\nValue: %@\nExpires: %@", [cookie name], [cookie value], [cookie expiresDate]);

			
			return YES;
		}
		else{
			return NO;
		}
		
	}
	@catch (NSException * e) {
		NSLog(@"Caught %@", [e name]);
		return NO;
	}
	
	return NO;	
} 


- (BOOL) checkURL :(NSString*)url {
	NSLog(@" --------- checkURL -----------");
	NSLog(@"[CHECK URL] Sakai url: %@",url);
	
	NSMutableURLRequest *request = [NSMutableURLRequest
									requestWithURL:[NSURL URLWithString:url]];
	[request setHTTPMethod: @"GET"];
	[request setHTTPShouldHandleCookies:NO];
	[request addValue:url forHTTPHeaderField:@"Referer"];


	NSURLResponse *response =[[NSURLResponse alloc]init];
	NSError *error = nil;
	
	//Calling the web service
	@try {
		
		[NSURLConnection sendSynchronousRequest:request returningResponse:&response error:&error]; 
		/*NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
		NSInteger status = [httpResponse statusCode];
		NSLog(@"Status: %d",status);
		if (status == 200) {
			NSLog(@"[CHECK URL] The url is working");
			return YES;
		}
		else{
			NSLog(@"[CHECK URL] The url is NOT working");
			return NO;
		}*/
		if(error == nil){
				NSLog(@"[CHECK URL] The url is working");
				return YES;
		}
		else{
			NSLog(@"[CHECK URL] The url is NOT working");
			return NO;
		}
			
	}
	@catch (NSException * e) {
		NSLog(@"Caught %@", [e name]);
		return NO;
	}
	
	return NO;	
} 



@end

/* NOTES:
 
 How to send JSON object:

 NSDictionary *requestData = [NSDictionary dictionaryWithObjectsAndKeys:
 @"sakaiauth:un", username,
 @"sakaiauth:pw", password,
 @"sakaiauth:login", @"1",
 @"_charset_", @"utf-8",
 ni
 -> JSON Object
 NSString *jsonString = [requestData JSONRepresentation];
 NSData *jsonData = [jsonString dataUsingEncoding:NSUTF8StringEncoding];
 NSLog(@"%@", jsonString);

 -> Sending JSON Object
 [request setValue:jsonString forHTTPHeaderField:@"json"];
 [request setValue:@"application/json" forHTTPHeaderField:@"Content-type"];
 [request setHTTPBody:jsonData];
 
*/
