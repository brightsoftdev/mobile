//
//  User.m
//  Nellodee
//
//  Created by Ada Hopper on 11/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "MeService.h"
#import "SBJson.h"
#import "BasicInfo.h"
#import "About.h"
#import "NellodeeApp.h"

@implementation MeService

@synthesize responseData;
@synthesize basicInfo,about;

-(BOOL) meService{
	NSLog(@" ---- me Service ---");
	NSMutableURLRequest *request = [NSMutableURLRequest
									requestWithURL:[NSURL URLWithString:@"http://sakai3-demo.uits.indiana.edu:8080/system/me"]];
	[request setHTTPMethod: @"GET"];
	[request setHTTPShouldHandleCookies:NO];
	[request addValue:@"http://sakai3-demo.uits.indiana.edu:8080/system/me" forHTTPHeaderField:@"Referer"];
	NSArray* cookies = [[NSHTTPCookieStorage sharedHTTPCookieStorage]
						cookiesForURL:[NSURL URLWithString:@"http://sakai3-demo.uits.indiana.edu:8080"]];
	NSDictionary* headers = [NSHTTPCookie requestHeaderFieldsWithCookies:cookies];
	
	if(cookies != nil){
		[request setAllHTTPHeaderFields:headers];
	}
	else{
		NSLog(@"Error: user no authenticated");
	}
	
	[[NSURLConnection alloc] initWithRequest:request delegate:self];  
	return YES;
	
} 




- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)response {  
	NSLog(@"didReceiveResponse");
	NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
	if ([httpResponse statusCode] >= 400) {
		NSLog(@"Remote url returned error %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
	} else {
		NSLog(@"It is working. Status: %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
		
	}
    [responseData setLength:0];  
}  

- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data {  
    basicInfo = [[BasicInfo alloc]init];
    
	NSLog(@"didReceiveData");    
    
    // Store incoming data into a string
    NSString *jsonString = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
    
    // Create a dictionary from the JSON string
    NSDictionary *results = [jsonString JSONValue];
    NSLog(@"Dictionary value for \"results\" is \"%@\"",results);

    [basicInfo setUsername:[[results objectForKey:@"user"] objectForKey:@"userid"]];
    NSString *userStoragePrefix = [[results objectForKey:@"user"] objectForKey:@"userStoragePrefix"];
    

    NSDictionary * properties = [[results objectForKey:@"user"] objectForKey:@"properties"];
    NSLog(@"Dictionary value for \"foo\" is \"%@\"",properties);
    
    //Since picture is not a dictionary property I get the substring with the name of the picture and build the path to the picture
    //I should have used a regex
    NSString * pic = [properties objectForKey:@"picture"];
    NSRange ini = [pic rangeOfString: @"name"];
    NSRange end = [pic rangeOfString: @"_name"];
    
    NSString *picture=[pic substringWithRange:NSMakeRange(ini.location+ini.length+2, end.location-(ini.location+ini.length)-4)];
    NSString *pathPicture = [[userStoragePrefix stringByAppendingString:@"profile/"] stringByAppendingString:picture];
    NSLog(@"Picture path: %@", pathPicture);
    
    [basicInfo setFirstName:[properties objectForKey:@"firstName"]];
    [basicInfo setLastName:[properties objectForKey:@"lastName"]];
    [basicInfo setPrefName:[properties objectForKey:@"preferredName"]];
    [basicInfo setEmail:[properties objectForKey:@"email"]];
    [basicInfo setRol:[properties objectForKey:@"role"]];
    [basicInfo setDepartament:[properties objectForKey:@"department"]];
    [basicInfo setCollege:[properties objectForKey:@"college"]];
    [basicInfo setTags:[properties objectForKey:@"sakai:tags"]];
    
    [[NellodeeApp sharedNellodeeData] setBasicInfo:basicInfo];
    
    about = [[About alloc] init];
    [about setAboutMe:@"me"];
    [about setAcademicInterests:@"academic"];
    [about setPersonalInterests:@"personal"];
    [about setHobbies:@"hobbies"];

    [[NellodeeApp sharedNellodeeData] setAbout:about];

}  

- (void)connection:(NSURLConnection *)connection didFailWithError:(NSError *)error {  
	NSLog(@"Connection failed: %@", [error description]);
}  

- (void)connectionDidFinishLoading:(NSURLConnection *)connection {  
	NSLog(@"connectionDidFinishLoading");
    [[NSNotificationCenter defaultCenter] postNotificationName:@"meServiceNotification" object:self];


    [connection release];  
    [responseData release];  
	
}  


- (void)dealloc {
    [about dealloc];
    [basicInfo dealloc];
    [responseData dealloc];
    [super dealloc];
}



@end
